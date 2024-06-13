package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	WebDriver ldriver;
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id = "SearchEmail")
	WebElement searchemail;
	@FindBy(id = "search-customers")
	WebElement searchcustomer;
	@FindBy(id = "customers-grid")
	WebElement searchresult;
	@FindBy(xpath = "//table[@id='customers-grid']//tr")
	List<WebElement> totalrows;
	@FindBy(xpath = "//table[@id='customers-grid']//tr[1]/td")
	List<WebElement> totalcolumns;
	
	public void enterEmail(String email) {
		searchemail.clear();
		searchemail.sendKeys(email);
	}
	
	public void serachcustomer() {
		searchcustomer.click();		
}
	public void SearchResult() {
		searchresult.click();		
}
	public boolean SearchEmailByCustomer(String email) {
		boolean status=false;
		int rowsize = totalrows.size();
		int columnsize = totalcolumns.size();
		
		//to fetch the data from the table
		for(int i=1;i<=rowsize;i++) {
			String expectedemail =ldriver.findElement(By.xpath("//table[@id='customers-grid']//tr["+i+"]/td[2]")).getText();
			if(expectedemail.equals(email)) {
				status=true;
				break;
			}
			
		}
		return status;
	}
	
}
