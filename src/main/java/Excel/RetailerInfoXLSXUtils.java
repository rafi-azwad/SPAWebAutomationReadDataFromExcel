package Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RetailerInfoXLSXUtils {
    public static List<String[]> readXLSXData(String filePath) throws IOException {
        List<String[]> dataList = new ArrayList<>();

        FileInputStream file = new FileInputStream(filePath);
        //Workbook workbook = new HSSFWorkbook(file);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows(); // Get total rows

        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                String code = getCellValue(row.getCell(0)); // Column 1
                String name = getCellValue(row.getCell(1)); // Column 2
                String address = getCellValue(row.getCell(2)); // Column 3
                String contactPerson = getCellValue(row.getCell(28)); // Column 29
                String contactNumber = getCellValue(row.getCell(3)); // Column 4
                String retailerType = getCellValue(row.getCell(6)); // Column 7
                String retailerCategory = getCellValue(row.getCell(5)); // Column 6
                String retailerLocation = getCellValue(row.getCell(26)); // Column 27
                String specialDiscount = getCellValue(row.getCell(12)); // Column 13
                String monthlyAvgSales = getCellValue(row.getCell(9)); // Column 10

                dataList.add(new String[]{code, name, address, contactPerson, contactNumber, retailerType,
                        retailerCategory, retailerLocation, specialDiscount, monthlyAvgSales});
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
                    return cell.getDateCellValue().toString(); // Convert date to string
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

