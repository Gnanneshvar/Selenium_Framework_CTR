package UsingPF;

import Setup.CommonClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF extends CommonClass {

    public HomePage_PF(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]")
    public WebElement eregistration;
    @FindBy(xpath="//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Assembly')]")
    public WebElement assembly_Constituency;
    @FindBy(xpath="//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Service Portal')]")
    public WebElement voterServicePortal;
    @FindBy(xpath="//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Voter Portal')]")
    public WebElement voterPortal;
    @FindBy(xpath="//ul[@id='menu-primary-menu']//a[contains(text(),'E-registration')]/following-sibling::ul//a[contains(text(),'Assembly')]/following-sibling::ul//a[contains(text(),'Claims')]")
    public WebElement claims;



    public void fnNavigateServicePortal_PF() throws InterruptedException {
        act = new Actions(webdriver);
        act.moveToElement(eregistration);
        Thread.sleep(2000);
        act.moveToElement(assembly_Constituency);
        Thread.sleep(2000);
        act.moveToElement(voterServicePortal).click().build().perform();
    }

}
