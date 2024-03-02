package Launch_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MouseOverAndClick {

    public static WebDriver driver;
    public static By eregistration = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]");
    public static By assemblyConstituency = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Assembly')]");
    public static By voterServicePortal = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Service Portal')]");
    public static By voterPortal = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Voter Portal')]");
    public static By claims = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Assembly')]/following-sibling::ul//a[contains(text(),'Claims')]");
    public static void main(String arg[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        List<String> list = new ArrayList<>();
        Actions act = new Actions(driver);
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
        WebElement username =driver.findElement(By.id("email"));
        act.moveToElement(username).sendKeys("testing@gmail.com");
        System.out.println("Get Text::"+username.getText());
        System.out.println("Value Attribute::"+username.getAttribute("value"));
        By password = By.id("pass");
        driver.findElement(password).sendKeys("Testing");
        act.moveToElement(driver.findElement(By.name("login"))).click();
        driver.findElement(By.name("login")).click();
        Thread.sleep(15000);
    }
}