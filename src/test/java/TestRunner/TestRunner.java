package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/login.feature",
        glue = {"stepdefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        dryRun = false

)
public class TestRunner {


}
