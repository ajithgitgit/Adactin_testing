package Utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
public class ExcelUtilis {
    public static String getUserName(String filepath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(0);

        String username1 = row.getCell(0).getStringCellValue();
        workbook.close();
        fis.close();
        return username1;
    }

    public static String getPassword(String filepath, String sheetName) throws Exception {
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(1);

        String password1 = row.getCell(1).getStringCellValue();
        workbook.close();
        fis.close();
        return password1;
    }
}