package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    static Map<String, String> dataMap1 = new TreeMap<>();
    static Map<String, String> dataMap2 = new TreeMap<>();
    static Map<String, String> resultMap = new LinkedHashMap<>();

    public static String generate(String filepath1, String filepath2) throws Exception {
        dataMap1 = Data.dataToMap(filepath1);
        dataMap2 = Data.dataToMap(filepath2);

        for (var key : dataMap1.keySet()) {
            if (dataMap2.containsKey(key)) {
                if (dataMap1.get(key).equals(dataMap2.get(key))) {
                    // Without changes
                    resultMap.put("  " + key, dataMap1.get(key));
                } else {
                    // The value has changed
                    resultMap.put(("- " + key), dataMap1.get(key));
                    resultMap.put(("+ " + key), dataMap2.get(key));
                }
            } else {
                // Key and value removed
                resultMap.put(("- " + key), dataMap1.get(key));
            }

        }

        for (var key : dataMap2.keySet()) {
            if (!dataMap1.containsKey(key)) {
                //Key and value add
                resultMap.put(("+ " + key), dataMap2.get(key));
            }
        }

        StringBuilder joinData = new StringBuilder();

        for (var key : resultMap.keySet()) {
            joinData.append(key)
                    .append(" ")
                    .append(resultMap.get(key))
                    .append("\n");
        }

        String result;

        result = "{\n" + joinData.toString().trim() + "\n}";

        System.out.println(result);

        return result;
    }

}
