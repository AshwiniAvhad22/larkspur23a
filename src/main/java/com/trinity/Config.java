package com.trinity;

import java.io.IOException;

import com.trinity.utilities.PropUtil;

public class Config {
	public String getBrowserName(){
		return readProperty("browser_name");
	}

	
	public String getAppURL() {
		return readProperty("app_url");
	}
	 public String getUsername() {
		 return readProperty("username");

	}
		

	
	private String readProperty(String property) {
		String baseDir=System.getProperty("user.dir");
		PropUtil prop= new PropUtil(baseDir+"/src/main/resources/Config.properties");
		String value=null;
		try {
			value=prop.getValue(property);
		} catch (IOException e) {
			
		}
		return value;
	}

}
