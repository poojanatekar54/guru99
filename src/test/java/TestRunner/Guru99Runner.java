package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features= {"AllFeatureFile/Guru99.feature"},
		glue= {"StepDef"},
		dryRun=false
				
		)

public class Guru99Runner {

}
