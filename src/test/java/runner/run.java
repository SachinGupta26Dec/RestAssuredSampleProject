package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = {
		"stepdef" }, monochrome = true, plugin = { "pretty", "json:target/jsonFolder/cucumber-report.json",
				"html:target/htmlFolder/cucumber-report/index.html", "rerun:target/rerunFolder/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:target/timelineFolder/" })

public class run extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
