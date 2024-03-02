package Launch_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Launching_Browser {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
        WebElement username =driver.findElement(By.id("email"));
        username.sendKeys("testing@gmail.com");
        System.out.println("Get Text::"+username.getText());
        System.out.println("Value Attribute::"+username.getAttribute("value"));
        By password = By.id("pass");
        driver.findElement(password).sendKeys("Testing");
        driver.findElement(By.name("login")).click();
        Thread.sleep(15000);
        boolean status = false;
        try
        {
            if(driver.findElement(By.xpath("//div[text()='Is this your account?']")).isDisplayed())
            {
                System.out.println("Not a valid login");
                String close = "//div[text()='Is this your account?']/preceding-sibling::div//i";
                driver.findElement(By.xpath(close)).click();
                status = true;
            }
        }catch(NoSuchElementException E)
        {
            System.out.println("Exception has been encounted");
        }
        if(!status)
        {
            System.out.println("Successfull login to the application");
            //logutfromthesystem();
        }

        System.out.println(driver.getCurrentUrl());// current url

        System.out.println(driver.getTitle());// Title of the page

        System.out.println(driver.getPageSource());// Page source html code

        driver.quit();
    }
}