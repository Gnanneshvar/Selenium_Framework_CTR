package Setup;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class CommonClass {

    public static WebDriver webdriver;
    public static WebElement webelement;
    public static Actions act;
    public static List<WebElement> webElements;
    public static Fillo fillo;
    public static Connection connection;
    public static Recordset recordset;
    public static String strQuery;

    public static void fnLaunchBrowser(String browser,String url)
    {
        if(browser.equalsIgnoreCase("chrome"))
            webdriver = new ChromeDriver();
        else if (browser.equalsIgnoreCase("Firefox")) {
            webdriver=new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            webdriver=new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            webdriver = new SafariDriver();
        }
        else
        {
            webdriver = new InternetExplorerDriver();
        }
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        webdriver.get(url);
    }
}
