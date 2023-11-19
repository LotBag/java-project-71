package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import static hexlet.code.Differ.generate;

public class DifferTest {
    @Test
    void differTestJson() throws Exception {

        String filePath1 = "app/src/test/resources/file1.json";
        String filePath2 = "app/src/test/resources/file2.json";

        try (FileWriter writer = new FileWriter("testActual", false)) {
            String text = generate(filePath1, filePath2);
            writer.write(text);
        }

        String actual = Parser.getData("app/src/test/resources/testActual");
        String expected = Parser.getData("app/src/test/resources/testExpected");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void differTestYml() throws Exception {

        String filePath1 = "app/src/test/resources/file1.yml";
        String filePath2 = "app/src/test/resources/file2.yml";

        try (FileWriter writer = new FileWriter("testActual", false)) {
            String text = generate(filePath1, filePath2);
            writer.write(text);
        }

        String actual = Parser.getData("app/src/test/resources/testActual");
        String expected = Parser.getData("app/src/test/resources/testExpected");
        Assertions.assertEquals(expected, actual);
    }
}
