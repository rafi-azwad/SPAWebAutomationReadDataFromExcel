
package Excel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FactoryInfoCSVUtils {
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
                String[] values = line.split(",", -1); // Keep empty values
                String col1 = values.length > 0 ? values[0] : "";
                String col2 = values.length > 1 ? values[1] : "";
                String col3 = values.length > 2 ? values[2] : "";

                dataList.add(new String[]{col1, col2, col3});
            }
        }

        return dataList;
    }
}

