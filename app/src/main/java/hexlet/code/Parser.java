package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Parser {

    public static String getData(String filepath) throws Exception {
        Path path = Paths.get(filepath.substring(filepath.indexOf("src")));
        return Files.readString(path);
    }

    public static List<String> prepareDataToMap(String filePath) throws Exception {
        String[] splitData = getData(filePath).split("\n");
        return Arrays.stream(splitData)
                .map(string -> string.replace("\"", ""))
                .map(string -> string.replace(",", ""))
                .filter(string -> !string.startsWith("{"))
                .filter(string -> !string.startsWith("}"))
                .map(string -> string.split(" "))
                .flatMap(Stream::of)
                .toList();
    }

    public static Map<String, String> dataToMap(String filePath) throws Exception {

        Map<String, String> tmp = new TreeMap<>();

        for (var i = 0; i < prepareDataToMap(filePath).size(); i += 2) {
            tmp.put(prepareDataToMap(filePath).get(i), prepareDataToMap(filePath).get(i + 1));
        }

        return tmp;
    }

}

