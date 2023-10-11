package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibuat.elements.General.*;
import static com.bibuat.elements.SignUpElements.*;
import static com.bibuat.elements.SignUpElements.PASSWORD_TXT_BOX;
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

    @Test
    @Given("I am at the Homepage to click the Signup page")
    public void iAmAtTheHomepageToClickTheSignupPage() throws InterruptedException {
        driver.get(PROD_WEBSITE_LINK);
        String actualTitle = "Buy/Sell Bitcoin, Ethereum and Altcoin | Spot / Perpetual Trading | BIB Cryptocurrency Exchange";
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, actualTitle);
        Thread.sleep(3000);
    }


    @And("Exit the prompt ads")
    public void exitThePromptAds() throws InterruptedException {
        WebElement x = getElementWithPolling(wait, By.xpath(X_PROMPT_BTN));
        x.click();
        Thread.sleep(3000);
    }

    @Test
    @When("I will click the Sign-Up page")
    public void iWillClickTheSignUpPage() throws InterruptedException {
        WebElement signup = getElementWithPolling(wait, By.xpath(SIGNUP));
        signup.click();
        Thread.sleep(3000L);
    }

    @Test
    @Then("Should be at Sign-Up page and Click the Email section")
    public void shouldBeAtSignUpPageAndClickTheEmailSection() throws InterruptedException {
        WebElement emailSection = getElementWithPolling(wait, By.cssSelector(EMAIL_SECTION_SIGNUP));
        emailSection.click();
        Thread.sleep(2000L);
    }
    @Given("I enter {string} a non-registered email account and enter a {string} password")
    public void iEnterANonRegisteredEmailAccountAndEnterAPassword(String email, String password) throws InterruptedException {
        WebElement emailTXTBox = getElementWithPolling(wait, By.xpath(EMAIL_TXT_BOX));
        emailTXTBox.sendKeys(email);
        Thread.sleep(2000L);
        WebElement emailPassword = getElementWithPolling(wait, By.xpath(PASSWORD_TXT_BOX));
        emailPassword.sendKeys(password);
        Thread.sleep(2000L);
    }


    @And("Click the hidden eye button in signup")
    public void clickTheHiddenEyeButtonInSignup() {
        WebElement sidEye = getElementWithPolling(wait, By.cssSelector(SID_EYE));
        sidEye.click();
    }

    @And("Enter optionally a Invitation Code")
    public void enterOptionallyAInvitationCode() {
        WebElement invitationCode = getElementWithPolling(wait, By.xpath(INVITATION_CODE_OPTIONAL));
        invitationCode.isDisplayed();
    }


    @And("I Click the check box agreement")
    public void iClickTheCheckBoxAgreement() {
        WebElement agreementCheckBox = getElementWithPolling(wait, By.cssSelector(CHECK_BOX_AGREEMENT));
        agreementCheckBox.click();
        agreementCheckBox.click();
    }


    @When("I click the Sign-Up Button")
    public void iClickTheSignUpButton() {
        WebElement signup = getElementWithPolling(wait, By.cssSelector(SIGNUP_BTN));
        signup.click();
    }

    @And("The Gee-Test prompt will show")
    public void theGeeTestPromptWillShow() throws InterruptedException {
        WebElement geetest = getElementWithPolling(wait, By.xpath(GEE_TEST));
        geetest.isDisplayed();
        Thread.sleep(3000);
    }


    @And("The Security Verification prompt will show")
    public void theSecurityVerificationPromptWillShow() throws InterruptedException {
        WebElement security = getElementWithPolling(wait, By.xpath(SECURITY_VERIFICATION));
        security.isDisplayed();
        Thread.sleep(2000L);
    }


    //    You can decide to create and get the code to your email provided or just check it the element is existing.
//    If you decide to create, change the isDisplayed to click
    @Then("The Confirm Button will click after entering the code")
    public void theConfirmButtonWillClickAfterEnteringTheCode() throws InterruptedException {
        WebElement securityTxtBox = getElementWithPolling(wait, By.xpath(SECURITY_VERIFICATION_TXTBOX));
        securityTxtBox.isDisplayed();
        Thread.sleep(2000L);
    }

    @And("The Send Notification prompt will displayed")
    public void theSendNotificationPromptWillDisplayed() {
        WebElement sendNotification = getElementWithPolling(wait, By.cssSelector(SEND_NOTIFICATION_PROMPT));
        sendNotification.isDisplayed();
    }

    @After
    @And("Will exit the webdriver")
    public void willExitTheWebdriver() throws InterruptedException {
        // Quit the driver
        driver.manage().deleteAllCookies(); // Deletes all the cookies
        driver.quit();
        Thread.sleep(3000L);
    }
}
