package com.alefEducation.RunnerClasses;
import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)


@CucumberOptions(features = {"src/test/resources"},
		glue= {"com.alefEducation.stepDefinations"},
		plugin= {"pretty","html:target/cucumber-reports", 
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/TestExecutionReport.html",
				},
						
		monochrome=true,
		dryRun=false
)


public class AlefEducation_Runner {
	
	@AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("User", System.getProperty("user.name"));
        Reporter.setSystemInfo("OS", "Windows");
        Reporter.setTestRunnerOutput("PetClinic :: a Spring Framework demonstration");
    }
}
