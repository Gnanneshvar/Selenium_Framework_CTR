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
import org.testng.annotations.BeforeSuite;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class CommonClass {

    public static WebDriver webdriver;
    public static WebElement webelement;
    public static Actions act;
    public static List<WebElement> webElements;
    public static Fillo fillo;
    public static Connection connection;
    public static Recordset recordset;
    public static String strQuery;
    public static String timeStamp;
    public static Properties props = new Properties();
    public static FileReader reader;
    public static String configPath = System.getProperty("user.dir")+"\\Config.properties";

    public static void fnLaunchBrowser(String url)
    {
        if(props.getProperty("Browser").equalsIgnoreCase("chrome"))
            webdriver = new ChromeDriver();
        else if (props.getProperty("Browser").equalsIgnoreCase("Firefox")) {
            webdriver=new FirefoxDriver();
        } else if (props.getProperty("Browser").equalsIgnoreCase("Edge")) {
            webdriver=new EdgeDriver();
        } else if (props.getProperty("Browser").equalsIgnoreCase("Safari")) {
            webdriver = new SafariDriver();
        }
        else
        {
            webdriver = new InternetExplorerDriver();
        }
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webdriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        if(url.length()>0)
            webdriver.get(url);
        else
            webdriver.get(props.getProperty("url"));
    }
    @BeforeSuite(alwaysRun = true)
    public void preCondition() throws IOException {
        reader=new FileReader(configPath);
        props.load(reader);

    }
}
