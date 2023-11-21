package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final String filePath1 = "app/src/test/resources/testFile1.json";
    private final String filePath2 = "app/src/test/resources/testFile2.json";
    private final String filePath3 = "src/test/resources/testFile1.yml";
    private final String filePath4 = "src/test/resources/testFile2.yml";

    private final Path pathStylish =
            Paths.get("src/test/resources/expected/expectedTestStylish").toAbsolutePath().normalize();;
    private final Path pathPlain =
            Paths.get("src/test/resources/expected/expectedTestPlain").toAbsolutePath().normalize();
    private final Path pathJson =
            Paths.get("src/test/resources/expected/expectedTestJson").toAbsolutePath().normalize();

    public DifferTest() throws IOException {
    }

    @Test
    public void defaultTest1() throws Exception {
        String expected =Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(filePath1, filePath2));
    }

    @Test
    public void testStylish1() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(filePath1, filePath2, "stylish"));
    }

    @Test
    public void testStylish2() throws Exception {
        String expected = Files.readString(pathStylish);
        assertEquals(expected, Differ.generate(filePath3, filePath4, "stylish"));
    }

    @Test
    public void testPlain1() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(filePath1, filePath2, "plain"));
    }

    @Test
    public void testPlain2() throws Exception {
        String expected = Files.readString(pathPlain);
        assertEquals(expected, Differ.generate(filePath3, filePath4, "plain"));
    }

    @Test
    public void testJson1() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(filePath1, filePath2, "json"));
    }

    @Test
    public void testJson2() throws Exception {
        String expected = Files.readString(pathJson);
        assertEquals(expected, Differ.generate(filePath3, filePath4, "json"));
    }

    @Test
    public void testZ() throws Exception {
        File file = new File("src/test/resources/testActual");
        try (FileWriter writer = new FileWriter(file, false)) {
            String text = Differ.generate(filePath1, filePath2);
            writer.write(text);
        }
        Path path1 = Path.of("src/test/resources/testActual");
        Path path2 = Path.of("src/test/resources/expected/expectedTestStylish");

        String actual = Files.readString(path1);
        String expected = Files.readString(path2);
        assertEquals(expected, actual);
    }
}



