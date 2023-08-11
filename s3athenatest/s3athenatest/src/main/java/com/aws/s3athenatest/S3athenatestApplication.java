
import java.util.List;
import java.util.ArrayList;

public class VerticalSumCalculator {

    public static List<Integer> calculateVerticalSum(List<List<String>> inputData) {
        List<Integer> verticalSums = new ArrayList<>();

        if (!inputData.isEmpty()) {
            int numColumns = inputData.get(0).size();

            // Initialize the verticalSums list with zeros
            for (int i = 0; i < numColumns; i++) {
                verticalSums.add(0);
            }

            for (List<String> row : inputData) {
                if (row.size() >= numColumns) {
                    for (int i = 0; i < numColumns; i++) {
                        try {
                            int value = Integer.parseInt(row.get(i));
                            verticalSums.set(i, verticalSums.get(i) + value);
                        } catch (NumberFormatException e) {
                            // Handle invalid number format if needed
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return verticalSums;
    }

    public static void main(String[] args) {
        List<List<String>> inputData = new ArrayList<>();
        List<String> row1 = new ArrayList<>();
        row1.add("10");
        row1.add("20");
        row1.add("30");
        row1.add("40");
        inputData.add(row1);

        List<String> row2 = new ArrayList<>();
        row2.add("5");
        row2.add("15");
        row2.add("25");
        row2.add("35");
        inputData.add(row2);

        List<Integer> verticalSums = calculateVerticalSum(inputData);
        System.out.println("Vertical Sums per Column:");
        for (Integer sum : verticalSums) {
            System.out.println(sum);
        }
    }
}
