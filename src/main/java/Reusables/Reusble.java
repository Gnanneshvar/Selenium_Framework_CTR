package Reusables;

import Setup.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Reusble extends CommonClass {
    public static boolean status;
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
}
