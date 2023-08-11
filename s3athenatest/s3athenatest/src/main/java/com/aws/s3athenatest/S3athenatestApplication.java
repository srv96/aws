
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileContentFilter {
    public static List<File> filterFilesWithPattern(String directoryPath) {
        List<File> filteredFiles = new ArrayList<>();
        
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Input path must be a directory.");
        }
        
        File[] files = directory.listFiles();
        if (files != null) {
            Pattern pattern = Pattern.compile("part-\\d{5}-[A-Za-z0-9]{7}");
            
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        String content = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                        Matcher matcher = pattern.matcher(content);
                        
                        if (matcher.find()) {
                            filteredFiles.add(file);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        return filteredFiles;
    }
    
    public static void main(String[] args) {
        String directoryPath = "path/to/your/directory";
        List<File> filteredFiles = filterFilesWithPattern(directoryPath);
        
        for (File file : filteredFiles) {
            System.out.println("Filtered File: " + file.getAbsolutePath());
        }
    }
}
