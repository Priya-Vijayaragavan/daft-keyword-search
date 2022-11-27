package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/daft.feature",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-Report.html", "json:target/report.json"}
)
public class DaftRun extends AbstractTestNGCucumberTests {
}
