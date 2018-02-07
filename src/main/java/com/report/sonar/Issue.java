package com.report.sonar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
	private String key;
	private String rule;
	private String severity;
	private String component;
	private Integer componentId;
	private String project;
	private TextRange textRange;
	private Object[] flows;
	private String resolution;
	private String status;
	private String message;
	private String author;
	private Object[] tags;
	private String creationDate;
	private String updateDate;
	private String closeDate;
	private String type;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the rule
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * @param rule
	 *            the rule to set
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the component
	 */
	public String getComponent() {
		return component;
	}

	/**
	 * @param component
	 *            the component to set
	 */
	public void setComponent(String component) {
		this.component = component;
	}

	/**
	 * @return the componentId
	 */
	public Integer getComponentId() {
		return componentId;
	}

	/**
	 * @param componentId
	 *            the componentId to set
	 */
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the textRange
	 */
	public TextRange getTextRange() {
		return textRange;
	}

	/**
	 * @param textRange
	 *            the textRange to set
	 */
	public void setTextRange(TextRange textRange) {
		this.textRange = textRange;
	}

	/**
	 * @return the flows
	 */
	public Object[] getFlows() {
		return flows;
	}

	/**
	 * @param flows
	 *            the flows to set
	 */
	public void setFlows(Object[] flows) {
		this.flows = flows;
	}

	/**
	 * @return the resolution
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * @param resolution
	 *            the resolution to set
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the tags
	 */
	public Object[] getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(Object[] tags) {
		this.tags = tags;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the closeDate
	 */
	public String getCloseDate() {
		return closeDate;
	}

	/**
	 * @param closeDate
	 *            the closeDate to set
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}