import Reusables.Reusble;
import Setup.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hanling_Alerts extends CommonClass {

    public static By seeAlert = By.id("alertButton");
    public static By timerAlert = By.id("timerAlertButton");
    public static By confirmButton = By.id("confirmButton");
    public static By promptButton = By.id("promtButton");
    public static WebDriverWait wait;
    public static void main(String arg[]) throws InterruptedException {
        fnLaunchBrowser("https://demoqa.com/alerts");
        wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
        // Click on seeAlert
        Reusble.click(Reusble.findelement(seeAlert));
        webdriver.switchTo().alert().accept();
        webdriver.switchTo().defaultContent();
        // Click on Timer Alert
        Reusble.click(Reusble.findelement(timerAlert));
        wait.until(ExpectedConditions.alertIsPresent());
        webdriver.switchTo().alert().accept();
        webdriver.switchTo().defaultContent();
        // Click on Confirm box alert
        Reusble.click(Reusble.findelement(confirmButton));
        webdriver.switchTo().alert().dismiss();
        Thread.sleep(4000);
        webdriver.switchTo().defaultContent();
        // click on prompt
        Reusble.click(Reusble.findelement(promptButton));
        webdriver.switchTo().alert().sendKeys("Testing");
        Thread.sleep(4000);
        webdriver.switchTo().alert().accept();
        webdriver.switchTo().defaultContent();
        Thread.sleep(5000);
        webdriver.quit();

        webdriver.quit();
    }
}
