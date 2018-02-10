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

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Application {
public static void main(String[] args) {
	RestTemplate template = new RestTemplate();
	template.setRequestFactory(new SimpleClientHttpRequestFactory());
	try {
		String firstPageQueryParams = "&p=1&ps=1";
		ResponseEntity<String> response = template.getForEntity(
				"http://ip/sonarqube/api/issues/search?componentRoots=projectname&statuses=OPEN,REOPENED"
						+ firstPageQueryParams,
				String.class);
		ObjectMapper mapper = new ObjectMapper();
		SonarResponse obj = mapper.readValue(response.getBody(), SonarResponse.class);
		// System.out.println("restcall completed");
		Integer numberOfPages = (obj.getTotal()/100)+1;

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("report");
		ArrayList<String> list = new ArrayList<>();
		String[][] arr = new String[obj.getTotal()+1][6];
		arr[0][0] = ("Component Id");
		arr[0][1] = ("Severity");
		arr[0][2] = ("Status");
		arr[0][3] = ("Resolution");
		arr[0][4] = ("Component");
		arr[0][5] = ("Message");
		String queryParamsPre = "&p=";
		String queryParamsPost = "&ps=100";
		int i =1;
		for (int j = 1; j <= numberOfPages; j++) {
			response = template.getForEntity(
					"http://ip/sonarqube/api/issues/search?componentRoots=projectname&statuses=OPEN,REOPENED"
							+ queryParamsPre + j ,
					String.class);
			obj = mapper.readValue(response.getBody(), SonarResponse.class);
			
			for(Issue issue : obj.getIssues()){
				arr[i][0] = (String.valueOf(issue.getComponentId()));
				arr[i][1] = (issue.getSeverity());
				arr[i][2] = (issue.getStatus());
				arr[i][3] = (issue.getResolution());
				arr[i][4] = (issue.getComponent());
				arr[i][5] = (issue.getMessage());
				System.out.println(i++);
			}
		}
		// TODO sdsfdsfdsfsdfsdfsdfsdfsdf
		ExcelSheetUtil util = new ExcelSheetUtil();
		util.writeRecordSetToSheet(arr, sheet);
		util.writeSheetToDisk(workbook);
	} catch (RestClientException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}




}
}
