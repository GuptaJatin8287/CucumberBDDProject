package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.LoginPage;
import PageObject.NewCustomer;
import PageObject.SearchCustomerPage;
import Utilities.Readconfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class LoginStepDef extends BaseClass {
	public WebDriver driver;
	public LoginPage loginpg;
	public NewCustomer newctm;
	public SearchCustomerPage Searchemail;
	
	
	@Before
	public void setup() {
		log = LogManager.getLogger("StepDef");
		System.out.println("Before method execute");
		readconfig = new Readconfig();
		
		String browser = readconfig.getbrowser();
		switch (browser.toLowerCase()) {
		case "chrome": 
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "msedge":
			driver = new EdgeDriver();
			break;
		}
		
		
	}
	/*
	 * @BeforeStep public void stepSetup() {
	 * System.out.println("Before step executed"); }
	 */
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		//driver = new ChromeDriver();
		loginpg = new LoginPage(driver);
		newctm = new NewCustomer(driver);
		Searchemail = new SearchCustomerPage(driver);
		log.info("Chrome Launched");
		
		}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		log.info("Url opened");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		loginpg.enteremail(email);
		loginpg.enterpassword(password);
		log.info("Enter email and password successfully");
	}

	@When("Click on Login")
	public void click_on_login() {
		loginpg.clickonlogin();
		log.info("Click on login successfully");

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedtitile) {
		String actualtitle=driver.getTitle();
		if(actualtitle.equals(expectedtitile)) {
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginpg.clickonlogout();
		log.info("Click on logout successfully");

	}

	
	
	//****************************For Adding New User****************************************
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		String actualtitle=loginpg.title();
		if(actualtitle.equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	    
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
	    newctm.clickoncustomer();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	    newctm.clickonsubcustomer();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	  newctm.clickonaddbutton();  
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualtitle=newctm.Registrationtitle();
		if(actualtitle.equals("Add a new customer / nopCommerce administration")) {
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
	    
	
		
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	   newctm.enteremail1(randomemail()+"@gmail.com");
	}

	@When("click on Save button")
	public void click_on_save_button() {
	   newctm.clickonSavebutton();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedresult) {
	    String bodytext = driver.findElement(By.tagName("body")).getText();
	    if(bodytext.contains(expectedresult)) {
	    	Assert.assertTrue(true);
	    }
	    else
	    	Assert.assertTrue(false);
	}
	
	//****************************For Searching Email****************************************
	
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		Searchemail.enterEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    Searchemail.SearchResult();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	    String Expectedemail="victoria_victoria@nopCommerce.com";
	    if( Searchemail.SearchEmailByCustomer(Expectedemail)==true) {
	    	Assert.assertTrue(true);
	    }
	    else
	    	Assert.assertTrue(false);
	}
	
	//@After
	public void teardown(Scenario sc) throws IOException {
		System.out.println("After method execute");
		if(sc.isFailed()==true){
			TakesScreenshot takess = (TakesScreenshot)driver;
			File source = takess.getScreenshotAs(OutputType.FILE);
			File target = new File("C:\\Java_Selenium_BDD_Framework\\BDDFramework\\target\\Screenshot\\Test1.png");
			FileUtils.copyFile(source, target);
		}
		driver.quit();
	}
	
	@AfterStep
	public void addScreenShot(Scenario sc) {
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(screenshot, "image/png", sc.getName());
		
	}
	/*
	 * @AfterStep public void stepclose() {
	 * System.out.println("After step executed"); }
	 */
	

}




