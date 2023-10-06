package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibuat.General.PROD_WEBSITE_LINK;
import static com.bibuat.General.X_PROMPT_BTN;
import static com.bibuat.LoginElements.*;
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

    //Homepage Navigation
    @Given("I am at the Homepage")
    public void iAmAtTheHomepage() throws InterruptedException {
        driver.get(PROD_WEBSITE_LINK);
        Thread.sleep(3000);
    }

    @And("Click the X button")
    public void clickTheXButton() throws InterruptedException {
        driver.findElement(By.xpath(X_PROMPT_BTN)).click();
        Thread.sleep(3000);
    }

    @When("I will click the Login page")
    public void iWillClickTheLoginPage(){
        WebElement clickLoginPage = getElementWithPolling(wait, By.xpath(LOGIN));
        clickLoginPage.click();
    }

    @Then("Should be at Login page and Click the Email section")
    public void shouldBeAtLoginPageAndClickTheEmailSection(){
        WebElement emailSection = getElementWithPolling(wait, By.xpath(EMAIL_SECTION));
        emailSection.click();
    }

    @Given("I enter a valid {string} address and a valid {string}")
    public void iEnterAValidAddressAndAValid(String email, String password) throws InterruptedException {
        driver.findElement(By.name(EMAIL_TEXT_BOX)).sendKeys(email);
        Thread.sleep(2000L);
        driver.findElement(By.xpath(EMAIL_PASSWORD)).sendKeys(password);
        Thread.sleep(2000L);
    }

    @And("Click the hidden eye button")
    public void clickTheHiddenEyeButton() {
        driver.findElement(By.cssSelector(EYE_BTN)).click();
    }

    @When("I will click the Login button")
    public void iWillClickTheLoginButton() throws InterruptedException {
        WebElement loginBTN = getElementWithPolling(wait, By.id(LOGIN_BTN));
        loginBTN.click();
        Thread.sleep(3000L);
    }

    @Then("Gee-test will prompt")
    public void geeTestWillPrompt() throws InterruptedException {
        driver.findElement(By.xpath(GEE_TEST)).isDisplayed();
        Thread.sleep(3000);
    }

    @Given("I enter a valid {string} address and a invalid {string}")
    public void iEnterAValidAddressAndAInvalid(String email, String password) throws InterruptedException {
        driver.findElement(By.name(EMAIL_TEXT_BOX)).sendKeys(email);
        Thread.sleep(2000L);
        driver.findElement(By.xpath(EMAIL_PASSWORD)).sendKeys(password);
        Thread.sleep(2000L);
    }

    @Then("The prompt of wrong password will show")
    public void thePromptOfWrongPasswordWillShow() {
        WebElement prompt = getElementWithPolling(wait, By.xpath(WRONG_PASSWORD_PROMPT));
        prompt.click();
    }
    @Given("I enter a Invalid {string} address and a invalid {string}")
    public void iEnterAInvalidAddressAndAInvalid(String email, String password) throws InterruptedException {
        driver.findElement(By.name(EMAIL_TEXT_BOX)).sendKeys(email);
        Thread.sleep(2000L);
        driver.findElement(By.xpath(EMAIL_PASSWORD)).sendKeys(password);
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