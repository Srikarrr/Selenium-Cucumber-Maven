package runner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepdef.Hooks;
 

@CucumberOptions(glue = "stepdef", features = "src/test/resources/features/", tags = "@Regression")
public class RunnerIT extends AbstractTestNGCucumberTests {
	String failtestcase;
	



	 

	
	@BeforeTest
	public void createProperties() {
		System.out.println("Before test");
	}

	@AfterSuite
	public void beforeTest() {
		String s = "";
		System.out.println("failedtescases are"+Hooks.failedcases);
		for (int i = 0; i < Hooks.failedcases.size(); i++) {
			s = s + Hooks.failedcases.get(i)+"or"+ " ";
		}
		s=s.substring(0,s.length()-1);
		try(OutputStream output = new FileOutputStream(
				System.getProperty("user.dir") + File.separator + "failedtestcases.properties")) {
			Properties prop = new Properties();
			// set the properties value
			prop.setProperty("failedtestcases", s);
			// save properties to project root folder
			prop.store(output, null);
			System.out.println("Properties are"+prop);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}