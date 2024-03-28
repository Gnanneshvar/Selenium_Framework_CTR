package Reusables;

import Setup.CommonClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Reusble extends CommonClass {
    public static boolean status;
    public static Select sel;
    public static List<WebElement> selList;

    public static JavascriptExecutor js;
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

    public static void type(WebElement element,String text,String webElementName)
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.isEnabled() && element.isDisplayed()) {
                element.click();
                element.clear();
                element.sendKeys(text);
                test.log(Status.INFO,"Entered Text for::"+webElementName+" as "+text);
            }

        }
        catch(Exception E)
        {
            test.log(Status.FAIL,"Failed to enter text for::"+webElementName);
        }
    }

    public static void click(WebElement element,String webElementName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            if(element.isEnabled() && element.isDisplayed()) {
                element.click();
                test.log(Status.INFO,"Clicked on::"+webElementName);
            }

        }
        catch(Exception E)
        {
            test.log(Status.FAIL,"Failed to click on ::"+webElementName);
            test.log(Status.FAIL,"Error Message as::"+E.getMessage());
        }
    }

    public static void selectByVisbileText(WebElement web,String value,String webElementName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            sel = new Select(web);
            sel.selectByVisibleText(value);
            test.log(Status.INFO,"Selected a "+value+" from dropdown "+webElementName);
        }
        catch(Exception E)
        {
            System.out.println("Unable to select the value");
            test.log(Status.FAIL,"Unable to select a "+value+" from dropdown "+webElementName);
            test.log(Status.FAIL,"Error Message as::"+E.getMessage());
        }
    }

    public static void selectByValue(WebElement web,String value,String webElementName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            sel = new Select(web);
            sel.selectByValue(value);
            test.log(Status.INFO,"Selected a "+value+" from dropdown "+webElementName);
        }
        catch(Exception E)
        {
            System.out.println("Unable to select the value");
            test.log(Status.FAIL,"Unable to select a "+value+" from dropdown "+webElementName);
            test.log(Status.FAIL,"Error Message as::"+E.getMessage());
        }
    }

    public static void selectByIndex(WebElement web,int value,String webElementName)
    {
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            sel = new Select(web);
            sel.selectByIndex(value); test.log(Status.INFO,"Selected a "+value+" from dropdown "+webElementName);
        }
        catch(Exception E)
        {
            System.out.println("Unable to select the value");
            test.log(Status.FAIL,"Unable to select a "+value+" from dropdown "+webElementName);
            test.log(Status.FAIL,"Error Message as::"+E.getMessage());
        }
    }

    public static void selectByOption(WebElement web,String value,String webElementName)
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
                    test.log(Status.INFO,"Selected a "+value +" from dropdown"+webElementName);
                    break;
                }
            }
            selList = null;
            webelement=null;
        }
        catch(StaleElementReferenceException E)
        {
            System.out.println("Stale Element Reference Exception");
            test.log(Status.FAIL,"Unable to select a "+value+" from dropdown "+webElementName);
            test.log(Status.FAIL,"Error Message as::"+E.getMessage());
        }
    }

    /**
     * Method to scroll down to the bottom of the page
     */

    public static void scrollDownToBottom()
    {
        js = (JavascriptExecutor)webdriver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    public static void scrollDownTopixel()
    {
        js = (JavascriptExecutor)webdriver;
        js.executeScript("window.scrollTo(0, 250)");
    }

    public static void jsClick(WebElement web,String webElementName)
    {
        js = (JavascriptExecutor) webdriver;
        try
        {
            wait.until(ExpectedConditions.elementToBeClickable(web));
            js.executeScript("argument[0].click()",web);
            test.log(Status.INFO,"Clicked on WebElement::"+webElementName);
        }
        catch(Exception E)
        {
            test.log(Status.FAIL,"Failed to click on ::"+webElementName);
            test.log(Status.FAIL,"Error Message as::"+E.getMessage());
        }
    }

    /**
     *
     * @param web
     * @param webElementName
     */
    public static void scrollDownTillWebElement(WebElement web,String webElementName)
    {
        js = (JavascriptExecutor)webdriver;
        try
        {
            js.executeScript("arguments[0].scrollIntoView(true)", web);
        }
        catch(Exception E)
        {
            //test.log(Status.FAIL, "The WebElement is not visible in the page::"+webElementName);
            //test.log(Status.FAIL,"Error Message as::"+E);
        }
    }

    /**
     *  This method is used to take the screenshot
     * @param screenShotName
     * @return
     * @throws IOException
     */

    public static String generateScreenShot(String screenShotName) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) webdriver;
        timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new java.util.Date());
        // Capture the screenshot as a File
        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);
        String destinationlocation = System.getProperty("user.dir")+"\\Failed_Screenshot\\"+screenShotName+timeStamp+".png";
        // Specify the destination directory and filename for the screenshot
        File destination = new File(destinationlocation);
        // Move the screenshot file to the specified destination
        FileHandler.copy(screenshotFile,destination);
        return destinationlocation;
    }
}
