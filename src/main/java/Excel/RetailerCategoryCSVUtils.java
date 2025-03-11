/*
package Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetailerCategoryExcelUtils {
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



                dataList.add(new String[]{code, name});
            }
        }

        workbook.close();
        file.close();
        return dataList;
    }
}*/


package Excel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetailerCategoryCSVUtils {
    public static List<String[]> readCSVData(String filePath) throws IOException {
        List<String[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }
                String[] values = line.split(","); // Assuming CSV is comma-separated
                if (values.length >= 2) {
                    dataList.add(new String[]{values[0], values[1]});
                }
            }
        }

        return dataList;
    }
}

