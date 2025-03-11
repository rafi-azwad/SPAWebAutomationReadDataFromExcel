package Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class _PriceInfoXLSUtils {
    public static List<String[]> readXLSData(String filePath) throws IOException {
        List<String[]> dataList = new ArrayList<>();

        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook;

        // Check file extension and open accordingly
        if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(file); // for XLS files
        } else {
            workbook = new XSSFWorkbook(file); // for XLSX files
        }

        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                String date = getCellValue(row.getCell(1)); // Column 1
                String code = getCellValue(row.getCell(2)); // Column 2
                String unitTP = getCellValue(row.getCell(3)); // Column 3
                String unitVat = getCellValue(row.getCell(4)); // Column 3
                String mrp = getCellValue(row.getCell(6)); // Column 7
                String employeePrice = getCellValue(row.getCell(7)); // Column 8
                String specialPrice = getCellValue(row.getCell(8)); // Column 9
                String grossProfit = getCellValue(row.getCell(9)); // Column 10

                dataList.add(new String[]{date, code, unitTP, unitVat, mrp, employeePrice, specialPrice, grossProfit});
            }
        }

        workbook.close();
        file.close();
        return dataList;
    }

    // Helper method to get cell value as a string
    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return ""; // Return empty string if cell is null
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim(); // Read string value
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
                    return dateFormat.format(cell.getDateCellValue()); // Convert date to formatted string
                } else {
                    return String.valueOf(cell.getNumericCellValue()); // Convert numeric value to string
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue()); // Convert boolean to string
            case FORMULA:
                return cell.getCellFormula(); // Return formula as string
            case BLANK:
            default:
                return ""; // Return empty string for blank/unknown cells
        }
    }
}
