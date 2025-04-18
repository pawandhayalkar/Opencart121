package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    // DataProvider 1
    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = ".\\testData\\Opencart_LoginData.xlsx"; // taking xl file from testData

        ExcelUtility xlutil = new ExcelUtility(path); // creating an object for ExcelUtility//path is missing

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String loginData[][] = new String[totalrows][totalcols]; // created for 2D array

        for (int i = 1; i <= totalrows; i++) { // i = rows
            for (int j = 0; j < totalcols; j++) { // j = columns
                loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // i-1 to start from 0 index
                //array index start with Zero[i-0]
            }
        }

        return loginData; // returning 2D array
    }
}
