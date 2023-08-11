import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class FileFilter {
    public static List<File> filterFilesByPattern(String directoryPath, String pattern) {
        List<File> filteredFiles = new ArrayList<>();
        
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Input path must be a directory.");
        }
        
        Pattern regexPattern = Pattern.compile(pattern);
        
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Matcher matcher = regexPattern.matcher(file.getName());
                    if (matcher.find()) {
                        filteredFiles.add(file);
                    }
                }
            }
        }
        
        return filteredFiles;
    }

    public static void main(String[] args) {
        String directoryPath = "path/to/your/directory";
        String pattern = "part-\\d{5}-[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}";
        
        List<File> filteredFiles = filterFilesByPattern(directoryPath, pattern);

        for (File file : filteredFiles) {
            System.out.println("Filtered File: " + file.getAbsolutePath());
        }
    }
}

