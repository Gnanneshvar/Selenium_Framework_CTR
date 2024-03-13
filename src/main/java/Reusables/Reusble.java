package Reusables;

import Setup.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Reusble extends CommonClass {
    public static boolean status;
    public static Select sel;
    public static List<WebElement> selList;
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
            System.out.println("Unable to click on WebElement");
            System.out.println(E.getMessage());
            E.printStackTrace();
        }
    }

    public static void selectByVisbileText(WebElement web,String value)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            sel = new Select(web);
            sel.selectByVisibleText(value);
        }
        catch(Exception E)
        {
            System.out.println("Unable to select the value");
        }
    }

    public static void selectByValue(WebElement web,String value)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            sel = new Select(web);
            sel.selectByValue(value);
        }
        catch(Exception E)
        {
            System.out.println("Unable to select the value");
        }
    }

    public static void selectByIndex(WebElement web,int value)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            sel = new Select(web);
            sel.selectByIndex(value);
        }
        catch(Exception E)
        {
            System.out.println("Unable to select the value");
        }
    }

    public static void selectByOption(WebElement web,String value)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            sel = new Select(web);
            selList = sel.getOptions();
            Iterator<WebElement> it = selList.iterator();
            while(it.hasNext())
            {
                webelement = it.next();
               // System.out.println(" "+webelement.getText());
                if(webelement.getText().equals(value)){
                    webelement.click();
                    break;
                }
            }
            selList = null;
            webelement=null;
        }
        catch(StaleElementReferenceException E)
        {
            System.out.println("Stale Element Reference Exception");
        }
    }

}
