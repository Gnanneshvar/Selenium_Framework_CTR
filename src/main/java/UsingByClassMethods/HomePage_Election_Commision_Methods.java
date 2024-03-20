package UsingByClassMethods;

import Reusables.Reusble;
import Setup.CommonClass;
import UsingByClass.HomePage_Election_Commision;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;

public class HomePage_Election_Commision_Methods extends CommonClass {

    public static void fnNavigateServicePortal() throws InterruptedException {
        act = new Actions(webdriver);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.eregistration));
        Thread.sleep(2000);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.assemblyConstituency));
        Thread.sleep(2000);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.voterServicePortal)).click().build().perform();
    }

    public static void fnNavigateClaims() throws InterruptedException {
        act = new Actions(webdriver);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.eregistration));
        Thread.sleep(2000);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.assemblyConstituency));
        Thread.sleep(2000);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.claims)).click().build().perform();
    }

    public static void fnNavigateVoterPortal() throws InterruptedException {
        act = new Actions(webdriver);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.eregistration));
        Thread.sleep(2000);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.assemblyConstituency));
        Thread.sleep(2000);
        act.moveToElement(Reusble.findelement(HomePage_Election_Commision.voterPortal)).click().build().perform();
    }

}