package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SeleniumPage {
	
	@FindBy(id="search_query_top")
	public WebElement searchProduct;
	
	@FindAll(@FindBy(css = "div[class='ac_results']>ul>li"))
	public List<WebElement> productList;
	
	@FindBy(id="add_to_cart")
	public WebElement addToCart;
	
	@FindBy(id="our_price_display")
	public WebElement initProductAmount;
	
	@FindBy(id="layer_cart_product_price")
	public WebElement productAmtOnSummaryPage;
	
	@FindBy(css="clearfix")
	public WebElement popupCheckout;
	
	@FindBy(css=".btn.btn-default.button.button-medium > span")
	public WebElement proceedBtn;
	
	@FindBy(css=".button.btn.btn-default.standard-checkout.button-medium > span")
	public WebElement proceedToCheckoutBtn;
	
	@FindBy(name ="processAddress")
	public WebElement proceedBtnToConfirmAddress;
	
	@FindBy(name ="processCarrier")
	public WebElement proceedBtnToProcessCarriers;
	
	@FindBy(id="cgv")
	public WebElement termOfService;
	
	@FindBy(className ="cheque")
	public WebElement paymentMode;
	
	@FindBy(css ="button[class='button btn btn-default button-medium']")
	public WebElement confirmOrderBtn;
	
	
	public SeleniumPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
}
