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

import static com.bibuat.General.PROD_WEBSITE_LINK;
import static com.bibuat.General.X_PROMPT_BTN;
import static com.bibuat.SignUpElements.*;
import static com.bibuat.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibuat.utility.ThinkingTimeUtil.getWebDriverWait;

public class SignUpStepsDefs {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SignUpStepsDefs() {
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


    @When("I will click the Sign-Up page")
    public void iWillClickTheSignUpPage() throws InterruptedException {
        WebElement signup = getElementWithPolling(wait, By.cssSelector(SIGNUP));
        signup.click();
        Thread.sleep(3000L);
    }

    @Then("Should be at Sign-Up page and Click the Email section")
    public void shouldBeAtSignUpPageAndClickTheEmailSection() {
        WebElement emailSection = getElementWithPolling(wait, By.xpath(EMAIL_SECTION));
        emailSection.click();
    }

    @Given("I enter {string} a non-registered email account and enter a {string} password")
    public void iEnterANonRegisteredEmailAccountAndEnterAPassword(String email, String password) {



    }

    @And("I Click the check box agreement")
    public void iClickTheCheckBoxAgreement() {
    }

    @When("I click the Sign-Up Button")
    public void iClickTheSignUpButton() {
    }

    @Then("The Gee-Test prompt will show")
    public void theGeeTestPromptWillShow() {
    }

    @And("The Security Verification prompt will show")
    public void theSecurityVerificationPromptWillShow() {
    }

    @And("The Confirm Button will click after entering the code")
    public void theConfirmButtonWillClickAfterEnteringTheCode() {
    }

    @Given("I enter <email> a non-registered email account and enter a <password> password")
    public void iEnterEmailANonRegisteredEmailAccountAndEnterAPasswordPassword() {
    }

}
