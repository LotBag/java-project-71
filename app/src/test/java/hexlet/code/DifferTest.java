package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.generate;


public class DifferTest {
    @Test
    void differTest() throws Exception {

        String filePath1 = "app/src/test/resources/file1.json";
        String filePath2 = "app/src/test/resources/file2.json";

        String expected = """
                {
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true
                }""";
        Assertions.assertEquals(expected, generate(filePath1, filePath2));
    }
}
