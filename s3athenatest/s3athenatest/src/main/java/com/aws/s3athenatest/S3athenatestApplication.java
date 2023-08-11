

import java.util.List;
import java.util.ArrayList;

public class DataProcessing {

    public static List<String> processRows(List<List<String>> inputData) {
        List<String> result = new ArrayList<>();

        for (List<String> row : inputData) {
            if (row.size() >= 3) {
                try {
                    int num1 = Integer.parseInt(row.get(0));
                    int num2 = Integer.parseInt(row.get(1));
                    int num3 = Integer.parseInt(row.get(2));
                    
                    int sum = num1 + num2 + num3;
                    String lastColumn = row.get(row.size() - 1);
                    int lastIndex = lastColumn.lastIndexOf('/');
                    
                    if (lastIndex != -1) {
                        String trimmedValue = lastColumn.substring(lastIndex + 1).trim();
                        result.add(sum + " " + trimmedValue);
                    } else {
                        result.add(sum + " " + lastColumn.trim());
                    }
                } catch (NumberFormatException e) {
                    // Handle invalid number format if needed
                    e.printStackTrace();
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> inputData = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("10");
        row1.add("20");
        row1.add("30");
        row1.add("Hello / World");
        inputData.add(row1);

        List<String> row2 = new ArrayList<>();
        row2.add("5");
        row2.add("15");
        row2.add("25");
        row2.add("Another / Example");
        inputData.add(row2);

        List<String> processedData = processRows(inputData);
        for (String row : processedData) {
            System.out.println(row);
        }
    }
}
