package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    public static String getCell(String path, String sheet, int row, int col) {
        try {
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            return wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

