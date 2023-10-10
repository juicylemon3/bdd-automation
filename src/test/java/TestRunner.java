import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
@RunWith(Cucumber.class)
public class TestRunner {
}
