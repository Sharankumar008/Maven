package com.project.pom;

import java.io.IOException;

public class ConfigHelper {

	private ConfigHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public static ConfigReader getConfigReader() throws IOException {
		ConfigReader configReader = new ConfigReader();
		return configReader;

	}

}
