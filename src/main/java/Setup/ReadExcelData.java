package Setup;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Fillo;

public class ReadExcelData extends CommonClass{
        //C:\Users\Admin\Desktop
        public static String fnGetFieldValue() throws FilloException
        {
            fillo=new Fillo();
            connection=fillo.getConnection("C:\\Users\\Admin\\Desktop\\Testing_Excel.xlsx");
            strQuery="Select * from UserInfo";// where Name='Ram'";
            recordset=connection.executeQuery(strQuery);
            while(recordset.next()){
                System.out.println("Row::");
                System.out.print("    "+recordset.getField("Sno"));
                System.out.print("     "+recordset.getField("Name"));
                System.out.print("     "+recordset.getField("Location"));
                System.out.println("  ");
            }
            recordset.close();
            connection.close();
            return null;
        }
}
