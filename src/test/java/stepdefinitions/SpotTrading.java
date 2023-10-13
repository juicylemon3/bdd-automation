package stepdefinitions;

import com.bibuat.elements.SpotElements;
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

import static com.bibuat.elements.SpotElements.*;
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
        List<WebElement> tradingPairs = driver.findElements(By.xpath(currencyXpathLeftSection
                + 1 + currencyXpathRightSection));
        if (tradingPairs.isEmpty()) {
            System.out.println("Element cannot click");
            return;
        }
        // Click on the first trading pair
        WebElement tradingPair = tradingPairs.get(0);
        tradingPair.click();
        tradingPair.isDisplayed();
    }

    //
    @When("I select the time frame")
    public void iSelectTheTimeFrame() {

        String[] kLines = {ONE_MINUTE, FIVE_MINUTES, FIFTEEN_MINUTES, THIRTY_MINUTES,
                ONE_HOUR, FOUR_HOUR, ONE_DAY, ONE_WEEK,ONE_MONTH,DROP_DOWN_LISTING, LINE, TIME_LINE_TRADING_PAIR};

        // Click the FIFTEEN_MINUTES, ONE_HOUR, FOUR_HOUR, ONE_DAY, ONE_WEEK timeframes first
        for (int i = 2; i <= 6; i++) {
            WebElement timeframeElement = driver.findElement(By.xpath(kLines[i]));
            timeframeElement.click();
        }

        // Click the DROP_DOWN_LISTING timeframe
        WebElement dropdownListingElement = driver.findElement(By.xpath(kLines[7]));
        dropdownListingElement.click();

        // Continue clicking the ONE_MINUTE, FIVE_MINUTES, THIRTY_MINUTES, ONE_MONTH, LINE timeframes
        for (int i = 0; i <= 1; i++) {
            WebElement timeframeElement = driver.findElement(By.xpath(kLines[i]));
            timeframeElement.click();
        }

        // Click the ONE_MONTH timeframe
        WebElement oneMonthTimeframeElement = driver.findElement(By.xpath(kLines[8]));
        oneMonthTimeframeElement.click();

        // Click the LINE timeframe
        WebElement lineTimeframeElement = driver.findElement(By.xpath(kLines[9]));
        lineTimeframeElement.click();

    }

    @Then("I should see that the klines are displayed with the time frame")
    public void iShouldSeeThatTheKlinesAreDisplayedWithTheTimeFrame() {

    }
}
