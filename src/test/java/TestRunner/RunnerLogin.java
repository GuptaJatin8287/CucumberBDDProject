package TestRunner;




import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features ={"src/test/resources/Features/LoginFeature.feature"},
        glue = {"StepDefination"},
        dryRun = true,
        monochrome = true,
        //tags = "@Sanity",
        //plugin = {"pretty","html:target/cucumber-report/report1.html","json:target/cucumber-report/json_report.json","junit:target/cucumber-report/xml_report.xml"}
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)


public class RunnerLogin extends AbstractTestNGCucumberTests {
//this class should be empty
}
