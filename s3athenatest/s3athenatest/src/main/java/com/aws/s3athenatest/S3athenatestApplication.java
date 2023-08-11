
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileToListExample {

    public static void main(String[] args) {
        String filePath = "path_to_your_file.txt"; // Replace with your file path

        List<List<String>> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\t");
                String[] lastColumn = columns[3].split(" ");

                List<String> rowList = new ArrayList<>();
                rowList.add(columns[0]);
                rowList.add(columns[1]);
                rowList.add(columns[2]);
                rowList.add(lastColumn[0]); // Assuming only one element in the last column

                dataList.add(rowList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the List<List<String>>
        for (List<String> row : dataList) {
            System.out.println(row);
        }
    }
}
