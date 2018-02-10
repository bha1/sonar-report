/**
 * @author Peeyush Bhawan
 * https://github.com/bha1
 * https://github.com/rogueagent
 *
 *
 */

package com.report.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SonarResponse {
	private Integer total;
	private Integer p;
	private Integer ps;
	private Paging paging;
	private Issue[] issues;
	private Component[] components;

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the p
	 */
	public Integer getP() {
		return p;
	}

	/**
	 * @param p
	 *            the p to set
	 */
	public void setP(Integer p) {
		this.p = p;
	}

	/**
	 * @return the ps
	 */
	public Integer getPs() {
		return ps;
	}

	/**
	 * @param ps
	 *            the ps to set
	 */
	public void setPs(Integer ps) {
		this.ps = ps;
	}

	/**
	 * @return the paging
	 */
	public Paging getPaging() {
		return paging;
	}

	/**
	 * @param paging
	 *            the paging to set
	 */
	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	/**
	 * @return the issues
	 */
	public Issue[] getIssues() {
		return issues;
	}

	/**
	 * @param issues
	 *            the issues to set
	 */
	public void setIssues(Issue[] issues) {
		this.issues = issues;
	}

	/**
	 * @return the components
	 */
	public Component[] getComponents() {
		return components;
	}

	/**
	 * @param components
	 *            the components to set
	 */
	public void setComponents(Component[] components) {
		this.components = components;
	}

}