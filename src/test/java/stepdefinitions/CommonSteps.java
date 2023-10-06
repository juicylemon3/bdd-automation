//package stepdefinitions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//import static com.bibuat.General.PROD_WEBSITE_LINK;
//import static com.bibuat.General.X_PROMPT_BTN;
//
//public class CommonSteps {
//    private static WebDriver driver;
//
//    public static void setWebDriver(WebDriver driver) {
//        CommonSteps.driver = driver;
//    }
//
//    public static void iAmAtTheHomepage(WebDriver driver) throws InterruptedException {
//        CommonSteps.driver.get(PROD_WEBSITE_LINK);
//        Thread.sleep(3000);
//    }
//
//    public static void clickTheXButton() throws InterruptedException {
//        driver.findElement(By.xpath(X_PROMPT_BTN)).click();
//        Thread.sleep(3000);
//    }
//
//    public void getWebDriver() throws InterruptedException {
//
//        iAmAtTheHomepage(driver);
//    }
//}
