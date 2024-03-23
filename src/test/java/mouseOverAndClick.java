
import Setup.CommonClass;
import UsingByClassMethods.HomePage_Election_Commision_Methods;

public class mouseOverAndClick extends CommonClass {

    public static void main(String arg[]) throws InterruptedException {
        fnLaunchBrowser("https://ceotelangana.nic.in/#");
        HomePage_Election_Commision_Methods.fnNavigateServicePortal();
        webdriver.quit();
    }
}