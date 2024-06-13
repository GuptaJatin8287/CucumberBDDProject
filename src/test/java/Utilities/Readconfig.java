package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class Readconfig {
	Properties property;
	String path="C:\\Java_Selenium_BDD_Framework\\BDDFramework\\config.properties";
	
	//Constructor
	public Readconfig(){
		property = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path);
			property.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//methods to read data from .properties file
	
	public String getbrowser() {
		String value2= property.getProperty("browser");
		if(value2!=null) {
			return value2;
		}
		else {
			throw new RuntimeException("Browser Value is null");
		}
		
	}
	

}
