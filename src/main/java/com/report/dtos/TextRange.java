/**
 * @author Peeyush Bhawan
 * https://github.com/bha1
 * https://github.com/rogueagent
 *
 *
 */

package com.report.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextRange {
	private Integer startLine;
	private Integer endLine;
	private Integer startOffset;
	private Integer endOffset;

	/**
	 * @return the startLine
	 */
	public Integer getStartLine() {
		return startLine;
	}

	/**
	 * @param startLine
	 *            the startLine to set
	 */
	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}

	/**
	 * @return the endLine
	 */
	public Integer getEndLine() {
		return endLine;
	}

	/**
	 * @param endLine
	 *            the endLine to set
	 */
	public void setEndLine(Integer endLine) {
		this.endLine = endLine;
	}

	/**
	 * @return the startOffset
	 */
	public Integer getStartOffset() {
		return startOffset;
	}

	/**
	 * @param startOffset
	 *            the startOffset to set
	 */
	public void setStartOffset(Integer startOffset) {
		this.startOffset = startOffset;
	}

	/**
	 * @return the endOffset
	 */
	public Integer getEndOffset() {
		return endOffset;
	}

	/**
	 * @param endOffset
	 *            the endOffset to set
	 */
	public void setEndOffset(Integer endOffset) {
		this.endOffset = endOffset;
	}

}