package UsingByClass;

import Setup.CommonClass;
import org.openqa.selenium.By;

public class HomePage_Election_Commision extends CommonClass {
    public static By eregistration = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]");
    public static By assemblyConstituency = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Assembly')]");
    public static By voterServicePortal = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Service Portal')]");
    public static By voterPortal = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Voter Portal')]");
    public static By claims = By.xpath("//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Assembly')]/following-sibling::ul//a[contains(text(),'Claims')]");
}
