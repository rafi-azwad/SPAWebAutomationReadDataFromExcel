package Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DivisionXLSUtils {
    public static List<String[]> readExcelData(String filePath) throws IOException {
        List<String[]> dataList = new ArrayList<>();

        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);



        int rowCount = sheet.getPhysicalNumberOfRows(); // Get total rows

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                String col1 = row.getCell(0).getStringCellValue(); // Column 1
                String col2 = row.getCell(1).getStringCellValue(); // Column 2




                dataList.add(new String[]{col1, col2});
            }
        }

        workbook.close();
        file.close();
        return dataList;
    }
}