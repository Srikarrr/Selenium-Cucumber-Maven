package stepdef;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import runner.FailedTestcasesList;
import runner.RunnerIT;

public class Hooks {
	FileInputStream fis;
	File file;
	public static List<String> failedcases=new LinkedList<String>();
	@Before
	public void beforeScenario() throws FileNotFoundException {
		System.out.println("This is before sceanrio");
	 }
	@After
	public void afterScenario(Scenario scn) {
		System.out.println("This is after sceanrio");
		if (scn.isFailed()) {
			Collection<String> listoftags = scn.getSourceTagNames();
			for (String tag : listoftags) {
				if (tag.contains("TC_")) {
				  failedcases.add(tag);
				  System.out.println("FT are"+failedcases);
				  
				}
			}
		}
		System.out.println("This will run after the Scenario");
	 
	}
}
