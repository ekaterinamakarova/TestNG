import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class TestClass {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.ru/?gws_rd=ssl");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test(description = "Test with exception", priority = 2)
    public void test1(){
        driver.findElement(By.id("name")).sendKeys("123");
        System.out.println("Test #1");
    }

    @Test(priority = 2, enabled = false)
    public void test2(){
        System.out.println("Test #2");
    }

    @Test(dependsOnMethods = "test1", alwaysRun = true)
    public void test4(){
        System.out.println("Test#4");
    }

    @Test(priority = 1, expectedExceptions = NullPointerException.class)
    public void test3(){
        Object ref = null;
        ref.toString();
        System.out.println("Test #3");
    }

    @Test(priority = 4, invocationCount = 3)
    public void test5(){
        System.out.println("Test#5");
    }

    @DataProvider(name = "testData")
    public Object [][] test6data(){
        Object [] [] data = new Object[3][2];

        data [0][0]= "user1";
        data [0][1] = "password1";

        data [1][0]= "user2";
        data [1][1] = "password2";

        data [2][0]= "user3";
        data [2][1] = "password3";
        return data;
    }

    @Test(dataProvider = "testData", priority = 5)
    public void test6(String username, String password){
        System.out.println("test#6:" +username + " " + password);
    }

    @AfterTest
    public void afterTest() throws IOException {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        File file1 = scr.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file1, new File("K:\\test1.PNG"));
        System.out.println("Screenshot of the test is taken");
        System.out.println("After test");
    }






}
