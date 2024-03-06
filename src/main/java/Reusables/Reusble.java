package Reusables;

import Setup.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Reusble extends CommonClass {
    public static boolean status;
    public static WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(40));
    public static WebElement findelement(By by)
    {
        webelement = webdriver.findElement(by);
        try
        {
            if(webelement.isDisplayed() && webelement.isEnabled())
                status = true;
        }
        catch(Exception E)
        {
            webelement=null;
        }
        return webelement;
    }

    public static void type(WebElement element,String text)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.isEnabled() && element.isDisplayed()) {
                element.click();
                element.clear();
                element.sendKeys(text);
            }

        }
        catch(Exception E)
        {

        }
    }

    public static void click(WebElement element)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if(element.isEnabled() && element.isDisplayed()) {
                element.click();
            }

        }
        catch(Exception E)
        {

        }
    }

}
