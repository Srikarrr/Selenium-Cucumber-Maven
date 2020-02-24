package stepdef;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import driver.SharedDriver;
import pageobject.ToolsHomePo;
import pageobject.ToolsLinks;

import org.testng.Assert;


public class ToolsStepDefinition {
	
	private ToolsHomePo thp;
	private ToolsLinks tl;
	public ToolsStepDefinition(SharedDriver driver, ToolsHomePo thp, ToolsLinks tl) {
		this.thp = thp;
		this.tl = tl;
	}
	@Given("user launches application {string}")
	public void user_launches_application(String string) {
	    // Write code here that turns the phrase above into concrete actions
		DriverFactory.getDriver().get(string);
		PageFactory.initElements(DriverFactory.getDriver(), this);
		thp.get();
	}
	
	@When("user clicks on {string} link")
	public void user_clicks_on_link(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		tl = thp.performSearch(string);
	}

	@Then("user validates link with {string}")
	public void user_validates_link_with(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String s=tl.validatetext(string);
		 Assert.assertEquals(s,"x1");
			
	}
}
