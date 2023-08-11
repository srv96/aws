import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvExporter {
    public static void exportToCsv(List<List<String>> data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (List<String> row : data) {
                StringBuilder csvRow = new StringBuilder();
                for (String cell : row) {
                    csvRow.append(cell).append(",");
                }
                csvRow.deleteCharAt(csvRow.length() - 1); // Remove trailing comma
                csvRow.append("\n");
                writer.write(csvRow.toString());
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> data = new ArrayList<>();
        data.add(List.of("John", "Doe", "30"));
        data.add(List.of("Jane", "Smith", "25"));
        data.add(List.of("Alice", "Johnson", "28"));

        String filePath = "output.csv";

        try {
            exportToCsv(data, filePath);
            System.out.println("Data exported to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
