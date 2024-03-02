import Launch_Browser.Launching_Browser;
import Setup.CommonClass;
import UsingByClassMethods.HomePage_Election_Commision_Methods;

public class mouseOverAndClick extends CommonClass {

    public static void main(String arg[]) throws InterruptedException {
        fnLaunchBrowser("Chrome","https://ceotelangana.nic.in/#");
        Thread.sleep(5000);
        HomePage_Election_Commision_Methods.fnNavigateServicePortal();
        Thread.sleep(5000);
        webdriver.quit();


    }
}
