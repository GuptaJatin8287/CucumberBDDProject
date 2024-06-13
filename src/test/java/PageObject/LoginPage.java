package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "Email")
	WebElement email1;
	@FindBy(id = "Password")
	WebElement Password1;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	
	public void enteremail(String email) {
		email1.clear();
		email1.sendKeys(email);
	}
	public void enterpassword(String Password) {
		Password1.clear();
		Password1.sendKeys(Password);
	}
	public void clickonlogin() {
		login.click();
	}
	public void clickonlogout() {
		logout.click();
	}
	public String title(){
		String title=ldriver.getTitle();
		return title;
		
	}

}
