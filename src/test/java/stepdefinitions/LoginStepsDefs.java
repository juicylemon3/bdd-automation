package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibuat.elements.General.*;
import static com.bibuat.elements.LoginElements.*;
import static com.bibuat.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibuat.utility.ThinkingTimeUtil.getWebDriverWait;


public class LoginStepsDefs {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public LoginStepsDefs() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = getWebDriverWait(driver);
    }

//    Homepage Navigation
    @Given("I am at the Homepage")
    public void iAmAtTheHomepage() throws InterruptedException {
        driver.get(PROD_WEBSITE_LINK);
        String actualTitle = "Buy/Sell Bitcoin, Ethereum and Altcoin | Spot / Perpetual Trading | BIB Cryptocurrency Exchange";
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, actualTitle);
        Thread.sleep(3000);
    }

    @And("Click the X button")
    public void clickTheXButton() throws InterruptedException {

        WebElement x = getElementWithPolling(wait,By.xpath(X_PROMPT_BTN));
        x.click();
        Thread.sleep(3000);
    }

    @When("I will click the Login page")
    public void iWillClickTheLoginPage(){
        WebElement clickLoginPage = getElementWithPolling(wait, By.xpath(LOGIN));
        clickLoginPage.click();
    }

    @Then("Should be at Login page and Click the Email section")
    public void shouldBeAtLoginPageAndClickTheEmailSection(){
        WebElement emailSection = getElementWithPolling(wait, By.xpath(EMAIL_SECTION_LOGIN));
        emailSection.click();
    }

    @Given("I enter a valid {string} address and a valid {string}")
    public void iEnterAValidAddressAndAValid(String email, String password) throws InterruptedException {
        WebElement emailTextBox = getElementWithPolling(wait,By.name(EMAIL_TEXT_BOX));
        emailTextBox.sendKeys(email);
        Thread.sleep(2000L);
        WebElement passwordTextBox = getElementWithPolling(wait,By.xpath(EMAIL_PASSWORD));
        passwordTextBox.sendKeys(password);
        Thread.sleep(2000L);
    }

    @And("Click the hidden eye button")
    public void clickTheHiddenEyeButton() {
        WebElement eyeBTN = getElementWithPolling(wait,By.cssSelector(EYE_BTN));
        eyeBTN.click();
    }

    @When("I will click the Login button")
    public void iWillClickTheLoginButton() throws InterruptedException {
        WebElement loginBTN = getElementWithPolling(wait, By.id(LOGIN_BTN));
        loginBTN.click();
        Thread.sleep(3000L);
    }

    @Then("Gee-test will prompt")
    public void geeTestWillPrompt() throws InterruptedException {
        WebElement geetest = getElementWithPolling(wait, By.xpath(GEE_TEST));
        geetest.isDisplayed();
        Thread.sleep(3000);
    }

    @Given("I enter a valid {string} address and a invalid {string}")
    public void iEnterAValidAddressAndAInvalid(String email, String password) throws InterruptedException {
        WebElement emailTextBox = getElementWithPolling(wait,By.name(EMAIL_TEXT_BOX));
        emailTextBox.sendKeys(email);
        Thread.sleep(2000L);
        WebElement passwordTextBox = getElementWithPolling(wait,By.xpath(EMAIL_PASSWORD));
        passwordTextBox.sendKeys(password);
        Thread.sleep(2000L);
    }

    @Then("The prompt of wrong password will show")
    public void thePromptOfWrongPasswordWillShow() {
        WebElement prompt = getElementWithPolling(wait, By.xpath(WRONG_PASSWORD_PROMPT));
        prompt.click();
    }
    @Given("I enter a Invalid {string} address and a invalid {string}")
    public void iEnterAInvalidAddressAndAInvalid(String email, String password) throws InterruptedException {
        WebElement emailTextBox = getElementWithPolling(wait,By.name(EMAIL_TEXT_BOX));
        emailTextBox.sendKeys(email);
        Thread.sleep(2000L);
        WebElement passwordTextBox = getElementWithPolling(wait,By.xpath(EMAIL_PASSWORD));
        passwordTextBox.sendKeys(password);
        Thread.sleep(2000L);
    }

    @Then("The prompt of non-registered email will show")
    public void thePromptOfNonRegisteredEmailWillShow() {
        WebElement prompt = getElementWithPolling(wait, By.cssSelector(NON_REGISTERED_ALERT));
        prompt.click();
    }

    @After
    @And("I quit the Driver")
    public void iQuitTheDriver() throws InterruptedException {
        // Quit the driver

        driver.manage().deleteAllCookies(); // Deletes all the cookies
        driver.quit();
        Thread.sleep(3000L);
    }
}