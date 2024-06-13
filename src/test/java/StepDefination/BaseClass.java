package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.LoginPage;
import PageObject.NewCustomer;
import PageObject.SearchCustomerPage;
import Utilities.Readconfig;



public class BaseClass  {
	public WebDriver driver;
	public LoginPage loginpg;
	public NewCustomer newctm;
	public SearchCustomerPage Searchemail;
	public static Logger log;
	public Readconfig readconfig;
	
	public String randomemail() {
		return(RandomStringUtils.randomAlphabetic(8));
		
	}

}
