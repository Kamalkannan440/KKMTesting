package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import Testcases.JVMreports;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\src\\test\\resources\\Documentupload.feature",
				 dryRun=false,
				 glue="Testcases",
				 tags="@Run",
				 plugin={"pretty","html:C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Reports\\HTML\\Workflowtmlreport.html",
						 "json:C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Reports\\Json\\workflowreport.json"})
public class TestRun extends JVMreports {
	@AfterClass
	public static void report() {
		generateJVMreport("C:\\Users\\TWINUser-08\\eclipse-workspace\\Automation_6D\\Reports\\Json\\workflowreport.json");
	}

}
