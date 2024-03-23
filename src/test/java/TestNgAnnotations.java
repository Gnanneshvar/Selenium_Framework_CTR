import Setup.CommonClass;
import org.testng.annotations.*;

public class TestNgAnnotations extends CommonClass {

    @BeforeSuite
    void beforeSuite()
    {
        System.out.println("Before Suite");
    }

    @AfterSuite
    void afterSuite()
    {
        System.out.println("After Suite");
    }

    @BeforeTest
    void beforeTest()
    {
        System.out.println("Before Test");
    }

    @AfterTest
    void afterTest()
    {
        System.out.println("After Test");
    }

    @BeforeClass
    void beforeclass()
    {
        System.out.println("Before Class");
    }

    @AfterClass
    void afterClass()
    {
        System.out.println("After Class");
    }

    @BeforeMethod
    void beforeMethod()
    {
        System.out.println("Before Method");
    }

    @AfterMethod()
    void afterMethod()
    {
        System.out.println("After Method");
    }

    @Test(priority=0)
    void test()
    {
        System.out.println(10/0);
    }

    @Test(priority = 1,dependsOnMethods = {"test"})
    void add()
    {
        System.out.println("Add");
    }
}
