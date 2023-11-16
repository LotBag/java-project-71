package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;

import static hexlet.code.Differ.generate;


public class DifferTest {
    @Test
    void differTest() throws Exception {

        String filePath1 = "app/src/test/resources/file1.json";
        String filePath2 = "app/src/test/resources/file2.json";

        try (FileWriter writer = new FileWriter("testExpected", false)) {
            String text = generate(filePath1, filePath2);
            writer.write(text);
        }

        String actual = Data.getData("app/src/test/resources/testExpected");
        String expected = Data.getData("app/src/test/resources/testExpected");
        Assertions.assertEquals(expected, actual);
    }
}
