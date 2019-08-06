import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    @Parameters({"string 1st", "string 2nd"})
    @Test
    public void first_second_lines(String param, String param2){
        System.out.println(param + "\n"+ param2);
    }

    @Parameters({"string 3rd"})
    @Test(priority = 1)
    public void third_line(String param){
        System.out.println(param);
    }

    @Parameters({"string 4th", "string 5th"})
    @Test(priority = 2)
    public void fourth_fifth_lines(String param, String param2){
        System.out.println(param + "\n"+ param2);
    }
}
