import Setup.CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HandlingFrames extends CommonClass {

    public static String frame1 ="frame1";
    public static String frame2 = "frame2";
    public static void main(String[] args) {
//        fnLaunchBrowser("Chrome","https://demoqa.com/frames");
//        webdriver.switchTo().frame(frame1);
//        System.out.println("Frame1 Text::"+webdriver.findElement(By.id("sampleHeading")).getText());
//        webdriver.switchTo().defaultContent();
//        webdriver.switchTo().frame(frame2);
//        System.out.println("Frame2 Text::"+webdriver.findElement(By.id("sampleHeading")).getText());
//        webdriver.quit();
        //webdriver.navigate().to("");
        // Navigating to Nested Frame URL:
        fnLaunchBrowser("https://demoqa.com/nestedframes");
        webdriver.switchTo().frame(frame1);
        List<WebElement> listFrame = webdriver.findElements(By.tagName("iframe"));
        System.out.println(listFrame.size());
        if(listFrame.size()>0)
        {
            for(int i=0;i<listFrame.size();i++)
            {
                webdriver.switchTo().frame(i);
                try
                {
                    if(webdriver.findElement(By.xpath("//p[text()='Child Iframe']")).isDisplayed()) {
                        System.out.println(webdriver.findElement(By.xpath("//p[text()='Child Iframe']")).getText());
                        break;
                    }
                }
                catch(Exception E)
                {
                    webdriver.switchTo().defaultContent();
                }
            }
        }
        webdriver.quit();

    }
}
