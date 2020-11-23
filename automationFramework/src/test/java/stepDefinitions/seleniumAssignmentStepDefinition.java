package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java8.En;
import pageObject.RegisterUserPage;
import pageObject.SeleniumPage;
import utils.BrowserSetup;

public class seleniumAssignmentStepDefinition implements En {

	String url;
	WebDriver driver;
	BrowserSetup browserObj = new BrowserSetup();
	SeleniumPage seleniumPageObj;
	RegisterUserPage registerUserPageObj;
	
	public seleniumAssignmentStepDefinition(){
		
		Given("user has the website access {string}", (String strUrl) -> {
			url = strUrl;
			driver = browserObj.driverSetup("ie");
			seleniumPageObj = new SeleniumPage(driver);
			registerUserPageObj = new RegisterUserPage(driver);
		});

		When("user navigate to website", () -> {
			browserObj.openApplication(driver, url);
		});

		When("search any product", () -> {
			browserObj.enterText(driver, seleniumPageObj.searchProduct, "dress");
		});

		When("select the second entry", () -> {
			browserObj.clickElement(driver, seleniumPageObj.productList.get(1));
		});

		When("click to Add cart", () -> {
			browserObj.scrollToElement(driver, seleniumPageObj.addToCart);
			browserObj.clickElement(driver, seleniumPageObj.addToCart);
		});

		When("click on proceed button", () -> {
			Thread.sleep(2000);
			browserObj.clickElement(driver, seleniumPageObj.proceedBtn);
		});

		When("compare summary amount with initial amount", () -> {
			browserObj.scrollToElement(driver, seleniumPageObj.proceedToCheckoutBtn);
			browserObj.clickElement(driver, seleniumPageObj.proceedToCheckoutBtn);
		});

		When("register the account", () -> {
			registerUserPageObj.registerUser(driver);
		});

		When("purchase the product", () -> {
			seleniumPageObj.purchaseProduct(driver);
		});

		Then("user validates the product is purchased successfully", () -> {
			
		});

		Then("user validates the proudct amount", () -> {
			
		});
	}
}
