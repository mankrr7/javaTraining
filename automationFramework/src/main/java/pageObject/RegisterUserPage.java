package pageObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utils.BrowserSetup;

public class RegisterUserPage {
	@FindBy(id="customer_firstname")
	public WebElement firstName;
	
	@FindBy(id="customer_lastname")
	public WebElement lastName;
	
	@FindBy(id="passwd")
	public WebElement password;
	
	@FindBy(id="address1")
	public WebElement address;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="id_state")
	public WebElement state;
	
	@FindBy(id="postcode")
	public WebElement zipcode;
	
	@FindBy(id="phone_mobile")
	public WebElement phoneNumber;
	
	@FindBy(id="other")
	public WebElement additionalDetails;
	
	@FindBy(id="submitAccount")
	public WebElement registerBtn;
	
	@FindBy(id="email_create")
	public WebElement emailId;
	
	@FindBy(id="SubmitCreate")
	public WebElement createAccountBtn;
	
	BrowserSetup browserObj = new BrowserSetup();
	
	public RegisterUserPage registerUser(WebDriver driver) {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hhmmss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    browserObj.enterText(driver, this.emailId, "abc"+formattedDate+"@gmail.com");
	    browserObj.scrollToElement(driver, this.createAccountBtn);
	    browserObj.clickElement(driver, this.createAccountBtn);
		browserObj.enterText(driver, this.firstName, "abc");
		browserObj.enterText(driver,  this.lastName, "xyz");
		browserObj.enterText(driver,this.password, "xyzabc");
		browserObj.scrollToElement(driver, this.address);
		browserObj.enterText(driver, this.address, "xyzabc");
		browserObj.scrollToElement(driver, this.city);
		browserObj.enterText(driver, this.city, "city");
		browserObj.scrollToElement(driver, this.state);
		Select selectState = new Select(this.state);
		selectState.selectByIndex(2);
		browserObj.scrollToElement(driver, this.zipcode);
		browserObj.enterText(driver, this.zipcode, "00000");
		browserObj.scrollToElement(driver, this.additionalDetails);
		browserObj.enterText(driver, this.additionalDetails, "9999999999");
		browserObj.scrollToElement(driver, this.phoneNumber);
		browserObj.enterText(driver, this.phoneNumber, "9999999999");
		browserObj.scrollToElement(driver, this.registerBtn);
		browserObj.clickElement(driver, this.registerBtn);
		return new RegisterUserPage(driver);
	}
	
	public RegisterUserPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
}
