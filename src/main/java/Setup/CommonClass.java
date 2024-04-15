package Setup;

import Reusables.Reusble;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
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
    public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static String reportName;
    public static Timestamp timestamp;
    public static String screenshotPath;
    public static String configPath = System.getProperty("user.dir")+"\\Config.properties";
    public static String jsonValue;
    public static File jsonReader;

    public static void fnLaunchBrowser(String url)
    {
        if(props.getProperty("Browser").equalsIgnoreCase("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless","--window-size=1920,1200","ignore-certificate-error");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-logging");
            webdriver=new ChromeDriver(options);
            System.out.println("Browser Launched");
//            webdriver = new ChromeDriver();
        }

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
        timestamp = new Timestamp(System.currentTimeMillis());
        extent = new ExtentReports();
        reportName = System.getProperty("user.dir")+"\\Reporting\\"+"Keys"+timestamp.getTime()+".html";
        spark = new ExtentSparkReporter(reportName);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Orange HRM Automation");
        extent.attachReporter(spark);
        extent.setSystemInfo("HostName", "Local Host");
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Company", "Automation labs");
        extent.setSystemInfo("Browser", props.getProperty("Browser"));
        extent.setSystemInfo("Environment", props.getProperty("Environment"));
    }

    @AfterSuite(alwaysRun = true)
    public void fnCloseAll()
    {
        extent.flush();
    }

    @AfterMethod(alwaysRun=true)
    public void ReportIT(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            screenshotPath = Reusble.generateScreenShot(result.getName());
            test.log(Status.FAIL, "Screen Shot as below::"+test.addScreenCaptureFromPath(screenshotPath));
            Assert.assertEquals(true,false);
        }
    }
}
