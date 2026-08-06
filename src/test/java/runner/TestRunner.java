package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Baseline.feature", glue = {"stepdefinitions", "pages", "hooks"}, plugin = { "pretty",
		"html:target/cucumber-reports.html",
				"json:target/cucumber.json",
				"junit:target/cucumber.xml"
},
		monochrome = true
)
public class TestRunner {
}
