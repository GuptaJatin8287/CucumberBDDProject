package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	WebDriver ldriver;
	public NewCustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath =  "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customer1;
	@FindBy(xpath =  "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement customer2;
	@FindBy(xpath =  "//a[@class='btn btn-primary']")
	WebElement add_button;
	@FindBy(id = "Email")
	WebElement Email;
	@FindBy(xpath = "//button[@name='save']")
	WebElement Save;
	
	
	
	public void clickoncustomer() {
		customer1.click();
	}
	public void clickonsubcustomer() {
		customer2.click();
	}
	public void clickonaddbutton() {
		add_button.click();
	}
	public String Registrationtitle(){
		String title=ldriver.getTitle();
		return title;
		
	}
	public void enteremail1(String email)
	{
		Email.sendKeys(email);
	}
	
	public void clickonSavebutton() {
		Save.click();
	}
	
	
}
