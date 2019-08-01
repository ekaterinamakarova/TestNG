import org.testng.annotations.*;

public class TestClass {

    @Test(priority = 2)
    public void test1(){
        System.out.println("Test #1");

    }
    @Test(priority = 1, enabled = false)
    public void test2(){
        System.out.println("Test #2");
    }

    @Test(priority = 3, expectedExceptions = NullPointerException.class)
    public void test3(){
        Object ref = null;
        ref.toString();
        System.out.println("Test #3");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }






}
