package com.report.enums;

public enum SonarStatus {
	OPEN("OPEN"), REOPENED("REOPENED"), CONFIRMED("CONFIRMED"), RESOLVED("RESOLVED"), CLOSED("CLOSED");
	
	String value;
	
	private SonarStatus(String value) {
		this.value=value;
	}
	
	public static SonarStatus fromValue(String value) {
		if(value==null)
			return null;
		
		for(SonarStatus sonarStatus:SonarStatus.values()) {
			if(sonarStatus.name().equals(value)) {
				return sonarStatus;
			}
		}
		return null;
	}
}
