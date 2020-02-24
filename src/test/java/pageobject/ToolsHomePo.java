package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import driver.DriverFactory;

public class ToolsHomePo extends LoadableComponent<ToolsHomePo> {

	@FindBy(xpath = "(//span[text()='Selenium Training'])[1]")
	private WebElement searchTextBox;

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

	public ToolsHomePo() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public ToolsLinks performSearch(String string) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread.sleep(5000);
		searchTextBox.click();
		waitForPageLoaded();
		Thread.sleep(5000);
		return new ToolsLinks();
	}

}
