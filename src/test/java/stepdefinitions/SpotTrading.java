package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.bibuat.elements.SpotElements.SPOT_TRADING;
import static com.bibuat.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibuat.utility.ThinkingTimeUtil.getWebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;


public class SpotTrading {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SpotTrading() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = getWebDriverWait(driver);
    }

    @Given("I am on the Spot page trading")
    public void iAmOnTheSpotPageTrading() {
        WebElement spotPage = getElementWithPolling(wait, By.xpath(SPOT_TRADING));
        spotPage.click();
        assertThat(spotPage).isNotNull();
    }
    @And("I select a trading pair")
    public void iSelectATradingPair() {
        // Flow - from 1st currency in the list - from left to right of timeframes - dropdown 4h to 1M
        String currencyXpathLeftSection = "/html/body/div[3]/div/div[2]/div/div/div/div[2]/div[1]" +
                "/div/div[2]/div[2]/div/div[1]/div/div[";
        String currencyXpathRightSection = "]/span[1]";

        // Check if there are any trading pairs available
        List<WebElement> tradingPairs = driver.findElements(By.xpath(currencyXpathLeftSection + 1 + currencyXpathRightSection));
        if (tradingPairs.isEmpty()) {
            System.out.println("Element cannot click");
            return;
        }
        // Click on the first trading pair
        WebElement tradingPair = tradingPairs.get(0);
        tradingPair.click();
        tradingPair.isDisplayed();

        // TODO
        // Start your timeframe test here
    }
//
    @When("I select the time frame")
    public void iSelectTheTimeFrame() {


    }

    @Then("I should see that the klines are displayed with the time frame")
    public void iShouldSeeThatTheKlinesAreDisplayedWithTheTimeFrame() {

    }
}
