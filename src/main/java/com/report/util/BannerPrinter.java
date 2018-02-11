/**
 * @author Peeyush Bhawan
 * https://github.com/bha1
 * https://github.com/rogueagent
 *
 *
 */

package com.report.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BannerPrinter {
	public void printBanner() {
		InputStream in = BannerPrinter.class.getClassLoader().getResourceAsStream("banner.txt");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
