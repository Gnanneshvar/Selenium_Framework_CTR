
import Setup.CommonClass;
import UsingByClassMethods.HomePage_Election_Commision_Methods;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Handling_Multiple_Windows extends CommonClass {
    static String parentWindow;
    @Test
    @Parameters({"URL"})
    public void multipleWindows(String url) throws InterruptedException, IOException {
        test = extent.createTest("Handling Multiple Windows");
        String childWindow;
        fnLaunchBrowser(url);
        HomePage_Election_Commision_Methods.fnNavigateServicePortal();
        Thread.sleep(3000);
        test.log(Status.INFO,"Sucessfull navigation of Service Portal");
        HomePage_Election_Commision_Methods.fnNavigateClaims();
        test.log(Status.PASS,"Sucessfull navigation of Claims Portal");
        parentWindow = webdriver.getWindowHandle();
        Set<String> setWindows = webdriver.getWindowHandles();
        test.log(Status.INFO,"No of Windows opened is::"+setWindows.size());
        System.out.println("Windows Size::"+setWindows.size());
        Iterator<String> it = setWindows.iterator();
        while(it.hasNext())
        {
            childWindow = it.next();
            if(!parentWindow.equals(childWindow))
            {
                webdriver.switchTo().window(childWindow);
                System.out.println("Title::"+webdriver.getTitle());
                System.out.println("URL::"+webdriver.getCurrentUrl());
                if(webdriver.getTitle().equals("Claims And Objections"))
                {

                }
                webdriver.close();
                Thread.sleep(3000);
            }
        }
        webdriver.switchTo().window(parentWindow);
//        webdriver.switchTo().window("xyz");
        test.log(Status.INFO,"Switched to Default Window");
        webdriver.quit();
    }
}
