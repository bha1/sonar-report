/**
 * @author Peeyush Bhawan
 * https://github.com/bha1
 * https://github.com/rogueagent
 *
 *
 */

package com.report.sonar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.report.dtos.Issue;
import com.report.dtos.SonarResponse;
import com.report.util.BannerPrinter;
import com.report.util.ExcelSheetUtil;

public class Application {

	public static final Logger logger = Logger.getLogger(Application.class.getName());

	private static HashMap<String, String> ruleMap = null;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger.getLogger(Application.class.getName()).setLevel(Level.INFO);
		new BannerPrinter().printBanner();
		ruleMap = new HashMap<>();
		ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));

		// getStatusFilter
		int iterations = argsList.size() / 2;
		if (argsList.size() % 2 != 0) {
			logger.info("This requires even number of arguments to execute !!");
			return;
		}
		String hostName = "";
		RestTemplate template = new RestTemplate();
		template.setRequestFactory(new SimpleClientHttpRequestFactory());
		String firstPageQueryParams = "&p=1&ps=1";
		ExcelSheetUtil util = new ExcelSheetUtil();
		XSSFWorkbook workbook = util.getNewWorkBook();
		try {
			for (int z = 0; z < iterations; z++) {
				XSSFSheet sheet = workbook.createSheet(argsList.get(z * 2));
				ResponseEntity<String> response = template
						.getForEntity(argsList.get((z * 2) + 1) + firstPageQueryParams, String.class);
				ObjectMapper mapper = new ObjectMapper();
				SonarResponse obj = mapper.readValue(response.getBody(), SonarResponse.class);
				hostName = argsList.get((z * 2) + 1).split("/sonarqube/")[0];
				Integer numberOfPages = (obj.getTotal() / 100) + 1;

				String[][] arr = new String[obj.getTotal() + 1][9];
				arr[0][0] = "Component Id";
				arr[0][1] = "Severity";
				arr[0][2] = "Status";
				arr[0][3] = "Resolution";
				arr[0][4] = "Component";
				arr[0][5] = "Rule";
				arr[0][6] = "Type";
				arr[0][7] = "Text Range";
				arr[0][8] = "Error Message";

				String queryParamsPre = "&p=";
				String queryParamsPost = "&ps=100";
				for (int j = 1; j <= numberOfPages; j++) {
					response = template.getForEntity(argsList.get((z * 2) + 1) + queryParamsPre + j + queryParamsPost,
							String.class);
					obj = mapper.readValue(response.getBody(), SonarResponse.class);

					for (Issue issue : obj.getIssues()) {
						arr[j][0] = String.valueOf(issue.getComponentId());
						arr[j][1] = issue.getSeverity();
						arr[j][2] = issue.getStatus();
						arr[j][3] = issue.getResolution();
						arr[j][4] = issue.getComponent();
						arr[j][5] = getRuleName(issue.getRule(),hostName);
						arr[j][6] = issue.getType();
						if (issue.getTextRange() != null) {
							arr[j][7] = (issue.getTextRange().getStartLine() + " - "
									+ issue.getTextRange().getEndLine());
						}
						arr[j][8] = issue.getMessage();
					}
				}
				util.writeRecordSetToSheet(arr, sheet);
			}
			util.writeSheetToDisk(workbook);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String getRuleName(String rule,String hostName) {
		if (ruleMap.containsKey(rule)) {
			return ruleMap.get(rule);
		}
		String name = null;
		RestTemplate template = new RestTemplate();
		template.setRequestFactory(new SimpleClientHttpRequestFactory());
		ResponseEntity<String> response = template.getForEntity(hostName+"/sonarqube/api/rules/show?key=" + rule,
				String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			SonarResponse obj = mapper.readValue(response.getBody(), SonarResponse.class);
			name = obj.getRule().getName();
			ruleMap.put(rule, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
