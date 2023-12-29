package excelDataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class dataProvide {

    //Target : need to send set of data to our test using data provider without hardcoded data
    //Each data should be run as single test case

    DataFormatter formatter=new DataFormatter(); //formatting the value stored in a Cell
    @Test(dataProvider ="employeeDataExcel")
    public void testCaseData(String firstName,String lastName,String age){
        System.out.println(firstName + lastName+ age);

    }

//This method will run 3 testcases each TC with different data , so result 3 passed TC
//Issue here we don't need to use hardcoded data
    @DataProvider (name="employeeData")
    public Object[][] getData(){
     Object[][] data={{"Mayada ","Ahmed ",30},{"Mona ","Hassan ",25},{"Laila ","Tarek ",28}};
     return data;
    }

//To solve hardocoded issue we will pass data at the data provider from excel sheet as below
    @DataProvider (name="employeeDataExcel")
    public Object[][] getDataExcel() throws IOException {
        FileInputStream file = new FileInputStream(new File("src/test/java/excelDataProvider/EmployeeData.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
//        int rowCount= sheet.getLastRowNum();         //retrieves the index of the last row in a spreadsheet even don't have values
        int rowCount=sheet.getPhysicalNumberOfRows();  //returns the number of rows actually used in the spreadsheet
        Row row= sheet.getRow(0);
        int colCount= row.getLastCellNum();
        Object[][] data= new Object[rowCount-1][colCount];
        for (int i=0; i<rowCount-1 ;i++){
            row= sheet.getRow(i+1);
            for (int j=0; j<colCount ;j++){
//                System.out.println(row.getCell(j));
//                data[i][j]=row.getCell(j);
                Cell cell =row.getCell(j);
                data[i][j]=formatter.formatCellValue(cell);
            }
        }
        return data;
    }

}
