import Setup.CommonClass;
import UsingPF.Claims;

public class WebTableVerfication extends CommonClass {
    public static void main(String args[]) throws InterruptedException {
        fnLaunchBrowser("https://ceotserms2.telangana.gov.in/MLC/Eroll_Forms/mlc_status.aspx");
        Claims obj = new Claims(webdriver);
        obj.fnFillingForm();
        obj.fnValidateTableWithText("DEEKSHA BAVARIA");
        obj.fnValidateTableWithTextColumnFixed("DEEKSHA BAVARIA");
    }
}
