package UsingPF;

import Reusables.Reusble;
import Setup.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Claims extends CommonClass {
    public Claims obj;
    public String name="DEEKSHA BAVARIA";
    public Claims(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(name="ddlac")
    public WebElement selectCC;
    @FindBy(name="ddldistrict")
    public WebElement selectDN;
    @FindBy(name="ddlformtype")
    public WebElement typeOfForm;
    @FindBy(id="rblsearch_0")
    public WebElement viewAll;
    @FindBy(name="btnsubmit")
    public WebElement submit;
    @FindBy(id="grvelectroldetailsform18")
    public WebElement nameTable;

    public void fnFillingForm() throws InterruptedException {
        Reusble.selectByVisbileText(selectCC, "Warangal-Khammam-Nalgonda");
        Thread.sleep(2000);
        Reusble.selectByOption(selectDN, "30-Bhadradri");
        Thread.sleep(2000);
        Reusble.selectByValue(typeOfForm, "1");
        //obj = new Claims(webdriver);
        //Reusble.click(viewAll);
        try
        {
            if(viewAll.isDisplayed() && viewAll.isEnabled())
                viewAll.click();
        }catch(StaleElementReferenceException e)
        {
            webelement = webdriver.findElement(By.id("rblsearch_0"));
            Reusble.click(webelement);
        }
        Reusble.click(submit);
    }

    public void fnValidateTableWithText(String text) throws InterruptedException {
        List<WebElement> colmn;
        boolean status = false;
        webElements = nameTable.findElements(By.tagName("tr"));
        for(int i=1;i<webElements.size();i++)
        {
            colmn = webElements.get(i).findElements(By.tagName("td"));
            for(int j=0;j<colmn.size();j++)
            {
                try
                {
                    //System.out.println(colmn.get(j).getText());
                    if(colmn.get(j).getText().equals(text)) {
                        status=true;
                        System.out.println("The Text is present in row and column as ::"+i +" "+j);
                        break;
                    }
                }
                catch(Exception E)
                {

                }
            }
            if(status) {
                break;
            }
        }
    }

    public void fnValidateTableWithTextColumnFixed(String text){
        String xpath =null;
        webElements = nameTable.findElements(By.tagName("tr"));
        for(int i=1;i<webElements.size();i++)
        {
            xpath = "//table[@id='grvelectroldetailsform18']//tr["+i+"]/td[3]";
            webelement = webdriver.findElement(By.xpath(xpath));
           // System.out.println(webelement.getText());
            if(webelement.getText().equals(text))
            {
                System.out.println("The String is present in the table");
                break;
            }
        }
    }
}
