import Setup.CommonClass;
import Setup.ReadJson;
import org.testng.annotations.Test;

public class Reading_JsonFile extends CommonClass {

    @Test
    public void readJson()
    {
        ReadJson.fnReadJsonFile("Testing");
        System.out.println(ReadJson.fnGet("userName"));
        System.out.println(ReadJson.fnGet("Address.District"));
        System.out.println(ReadJson.fnGet("Gender.Male.Age"));
    }
}
