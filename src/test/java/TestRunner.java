import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/features/spottrading",
        glue = "stepdefinitions",
        plugin = {"json:target/cucumber-report.json","html:target/cucumber-html",
                "pretty", "html:target/cucumber-reports.html"}
)
@RunWith(Cucumber.class)
public class TestRunner {
}
