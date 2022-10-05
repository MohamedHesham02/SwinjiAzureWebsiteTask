package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class trial {

    public static void main(String args[]) throws IOException {
        FileInputStream TestData = new FileInputStream("C:\\Users\\Mohamed\\IdeaProjects\\SwinjiAzureWebsite\\src\\main\\resources\\TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(TestData);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String courseName = "Software Testing";
        String path = "//*[text()='"+courseName+"']";
        System.out.println(path);

        for(int i = 0; i<=22; i++){

            try {
                //  Block of code to try
                String val = sheet.getRow(i).getCell(1).toString();
                double valin = Double.parseDouble(val);
                int valy = (int) valin;
                System.out.println(valin);
                System.out.println(valy);
            }
            catch(Exception e) {
                //  Block of code to handle errors
                String val = sheet.getRow(i).getCell(1).toString();
                System.out.println(val);
            }
            /*
            Boolean bool = val.contains("A");
            if (val.contains("A") == true){
                System.out.println("got y");
            }

             */

        }

    }
}
