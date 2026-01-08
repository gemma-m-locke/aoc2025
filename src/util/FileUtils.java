package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    public static List<String> readFile(String day, String file) {

        File f = Paths.get("src", day, file).toFile();
        try (FileReader fileReader = new FileReader(f)) {
            return fileReader.readAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
