package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java8.En;
import pageObject.RegisterUserPage;
import pageObject.SeleniumPage;
import utils.BrowserSetup;

public class seleniumAssignmentStepDefinition implements En {

	String url;
	WebDriver driver = null;
	BrowserSetup browserObj = new BrowserSetup();
	SeleniumPage seleniumPageObj;
	RegisterUserPage registerUserPageObj;
	String initialProductAmt = "";
	String summaryProductAmt = "";
	String finalOrderAmt = "";
	String orderSuccessMsg = "";

	public seleniumAssignmentStepDefinition() {

		Given("user has the website access {string} on {string}", (String strUrl, String browserName) -> {
			url = strUrl;
			driver = browserObj.driverSetup(browserName);
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
			initialProductAmt = seleniumPageObj.initialProductAmount.getText();
			System.out.println("Initial product amount: " + initialProductAmt);
			browserObj.clickElement(driver, seleniumPageObj.proceedBtn);
			browserObj.scrollToElement(driver, seleniumPageObj.summaryProductAmount);
			summaryProductAmt = seleniumPageObj.summaryProductAmount.getText();
			System.out.println("Summary page product amount: " + summaryProductAmt);
		});

		When("compare summary amount with initial amount", () -> {
			assertEquals(initialProductAmt, summaryProductAmt);
		});

		When("register the account", () -> {
			browserObj.scrollToElement(driver, seleniumPageObj.proceedToCheckoutBtn);
			browserObj.clickElement(driver, seleniumPageObj.proceedToCheckoutBtn);
			registerUserPageObj.registerUser(driver);
		});

		When("purchase the product", () -> {
			seleniumPageObj.purchaseProduct(driver);
		});

		Then("user validates the product is purchased successfully", () -> {
			orderSuccessMsg = seleniumPageObj.orderSuccessfulMsg.getText();
			System.out.println("orderSuccessMsg: " + orderSuccessMsg);
			assertEquals("Your order on My Store is complete.", orderSuccessMsg);
		});

		Then("user validates the product amount", () -> {
			finalOrderAmt = seleniumPageObj.finalOrderAmount.getText();
			System.out.println("Final order product amount: " + finalOrderAmt);
			assertEquals(initialProductAmt, finalOrderAmt);
		});

		Then("user closes the website", () -> {
			browserObj.quitDriver(driver);
		});
	}
}
