import Setup.CommonClass;
import UsingByClassMethods.HomePage_Election_Commision_Methods;
import UsingPF.HomePage_PF;

public class MouseOverAndClick_PF extends CommonClass {
    public static void main(String arg[]) throws InterruptedException {
        fnLaunchBrowser("https://ceotelangana.nic.in/#");
        Thread.sleep(5000);
        HomePage_PF obj = new HomePage_PF(webdriver);
        obj.fnNavigateServicePortal_PF();
        //HomePage_Election_Commision_Methods.fnNavigateServicePortal();
        Thread.sleep(5000);
        webdriver.quit();
    }
}
