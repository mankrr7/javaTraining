package utils;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSetup {
	
	WebDriver driver;

	public WebDriver driverSetup(String browser) {
		if (browser.equals("chrome")) {
			String driverPath = System.getProperty("user.dir") + File.separator
					+ "src\\test\\resource\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}
		else if (browser.equals("ie")) {
			String driverPath = System.getProperty("user.dir") + File.separator
					+ "src\\test\\resource\\drivers\\msedgedriver.exe";
			System. setProperty("webdriver.edge.driver", driverPath);
			driver = new EdgeDriver();
		}
		return driver;
	}

	public void openApplication(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
	}

	public void clickElement(WebDriver driver, WebElement locator) {
		locator.click();
	}

	public void enterText(WebDriver driver, WebElement locator, String text) {
		locator.clear();
		locator.sendKeys(text);
	}

	public void scrollToElement(WebDriver driver, WebElement locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locator);
	}
}
