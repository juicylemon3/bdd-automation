package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static com.bibuat.elements.SpotElements.SPOT_TRADING;
import static com.bibuat.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibuat.utility.ThinkingTimeUtil.getWebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;


public class SpotTrading {

    private final String BTC = "/html/body/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div/div[1]/span[1]";
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


    @Test
    @Given("I am on the Spot page trading")
    public void iAmOnTheSpotPageTrading() {
        WebElement spotPage = getElementWithPolling(wait, By.xpath(SPOT_TRADING));
        spotPage.click();
        assertThat(spotPage).isNotNull();
    }

    @Test
    @And("I select a trading pair")
    public void iSelectATradingPair() {

        //Flow - from 1st currency in the list - from left to right of timeframes - dropdown 4h to 1M

        String currencyXpathLeftSection = "/html/body/div[3]/div/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div[2]/div/div[1]/div/div[";
        String currencyXpathRightSection = "]/span[1]";



        for(int i = 0; i > 92; i++) {
            String count = String.valueOf(i);
            String currentSelectedCurrency = currencyXpathLeftSection + count + currencyXpathRightSection;
            WebElement selectCurrency = getElementWithPolling(wait, By.xpath(currentSelectedCurrency));
            selectCurrency.click();

            /***TODO
             * here start your timeframe test
             * 1. select a time frame
             * 2. verify the TIME_LINE_TRADING_PAIR by:
             * 2.1 BTCUSDT 5 = should substring the currency_pair then get the minutes (5), for hours and day make it to minutes
             * 3. Assert that each timeframe has the same value in the substring 2nd value of TIME_LINE_TRADING_PAIR*/

        }

//


    }

    @When("I select the time frame")
    public void iSelectTheTimeFrame() {


    }

    @Then("I should see that the klines are displayed with the time frame")
    public void iShouldSeeThatTheKlinesAreDisplayedWithTheTimeFrame() {

    }
}
