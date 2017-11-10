package csptest.cucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome=true,
		features = "src/test/resources/features/test",  //test
		//features = "test-classes/features/test",          //prod
		glue = "csptest.stepDefinitions",
		plugin = {
					"pretty",
					"html:target/cucumber",
					"json:target/cucumber/test-result.json"
				}
		)
public class RunCukeTest {
}