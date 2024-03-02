package Launch_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectingValueFromDropDown {
    public static Select sel;
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        Thread.sleep(2000);
        WebElement day = driver.findElement(By.id("day"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement year = driver.findElement(By.id("year"));
        sel = new Select(day);
        sel.selectByValue("10");
        System.out.println("Selected Day::"+sel.getFirstSelectedOption().getText());
        sel = null;
        sel = new Select(month);
        sel.selectByIndex(5);
        System.out.println("Selected Month::"+sel.getFirstSelectedOption().getText());
        sel = null;
        sel = new Select(year);
        sel.selectByVisibleText("2000");
        System.out.println("Selected Year::"+sel.getFirstSelectedOption().getText());
        Thread.sleep(3000);
        driver.quit();
    }
}