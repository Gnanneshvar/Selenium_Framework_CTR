import Reusables.Reusble;
import Setup.CommonClass;
import UsingByClassMethods.HomePage_Election_Commision_Methods;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Handling_Multiple_Windows extends CommonClass {
    static String parentWindow;
    public static void main(String[] args) throws InterruptedException, IOException {
        String childWindow;
        fnLaunchBrowser("https://ceotelangana.nic.in/#");
        HomePage_Election_Commision_Methods.fnNavigateServicePortal();
        Thread.sleep(3000);
        HomePage_Election_Commision_Methods.fnNavigateClaims();
        parentWindow = webdriver.getWindowHandle();
        Set<String> setWindows = webdriver.getWindowHandles();
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
        Reusble.generateScreenShot("Testing");
        webdriver.quit();
    }
}
