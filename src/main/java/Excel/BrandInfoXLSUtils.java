package Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BrandInfoXLSUtils {
    public static List<String[]> readExcelData(String filePath) throws IOException {
        List<String[]> dataList = new ArrayList<>();

        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);



        int rowCount = sheet.getPhysicalNumberOfRows(); // Get total rows

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                String code = row.getCell(0).getStringCellValue(); // Column 1
                String name = row.getCell(1).getStringCellValue(); // Column 2
                String type = row.getCell(2).getStringCellValue(); // Column 3
                String remark = row.getCell(4).getStringCellValue(); // Column 4


                dataList.add(new String[]{code, name, type, remark});
            }
        }

        workbook.close();
        file.close();
        return dataList;
    }
}