package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;

public class ToolsLinks {
  
	@FindBy(xpath = "//strong[contains(./text(),'Module')][not(contains(./text(),'8'))]")
	private WebElement searchTextBox;
	public String validatetext(String string) {
		// TODO Auto-generated method stub
		return searchTextBox.getText();
	}
    public ToolsLinks() {
    	PageFactory.initElements(DriverFactory.getDriver(),this);
    }
}
