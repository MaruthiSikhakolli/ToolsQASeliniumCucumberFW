package runners;
import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.FileReaderManager;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests/End2End_Test.feature",
		glue= {"stepDefinitions"},
		tags = "@MyTest",
		monochrome = true,
		plugin = { "pretty", "html:target/cucumber-reports.html"}
//		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json"}
//		plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml"}
//		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml", "html:target/cucumber-reports"}
//		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)

public class TestRunner {
//	@AfterClass
//	public static void writeExtentReport() {
//			Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
//		    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//		    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
//		    Reporter.setSystemInfo("Selenium", "3.7.0");
//		    Reporter.setSystemInfo("Maven", "3.5.2");
//		    Reporter.setSystemInfo("Java Version", "1.8.0_151");
//	}
}