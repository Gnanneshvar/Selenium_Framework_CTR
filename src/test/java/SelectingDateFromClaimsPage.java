import Setup.CommonClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectingDateFromClaimsPage extends CommonClass {

    @BeforeClass
    public void navigation()
    {
        fnLaunchBrowser("https://ceotserms2.telangana.gov.in/claimsobjections/claims_objections.aspx");
    }

    @Test
    public void selectDate()
    {

    }

}
