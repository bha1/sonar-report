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
public class Rule {
private String name;
private String key;
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the key
 */
public String getKey() {
	return key;
}
/**
 * @param key the key to set
 */
public void setKey(String key) {
	this.key = key;
}

}
