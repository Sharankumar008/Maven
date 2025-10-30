package com.project.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public Properties pr;

	public ConfigReader() throws IOException {
		File f=new File(".\\src\\main\\java\\com\\project\\pom\\amazon.properties");
		FileInputStream fi=new FileInputStream(f);
		pr=new Properties();
		pr.load(fi);		
	}
	public String getBrowser() {
		String browser = pr.getProperty("browser");
		return browser;
	}
	public String getUrl() {
		String url = pr.getProperty("url");
		return url;
	}
	public String getEmail() {
		String email = pr.getProperty("email");
		return email;
	}
	public String getPass() {
		String pass = pr.getProperty("pass");
		return pass;
	}

}
