package Setup;

import com.jayway.jsonpath.JsonPath;

import java.io.File;

public class ReadJson extends CommonClass{

    /**
     * This method is used to get the value from the json file
     * @param key
     * @return
     */
    public static String fnGet(String key)
    {
        try
        {
            jsonValue = JsonPath.read(jsonReader,"$."+key);
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
        return jsonValue;
    }

    /**
     * This Method is used to Read the json file.
     * @param fileName
     */

    public static void fnReadJsonFile(String fileName)
    {
        jsonReader = new File(System.getProperty("user.dir")+"/TestData/"+fileName+".json");
    }

}
