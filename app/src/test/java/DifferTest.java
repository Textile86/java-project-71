import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    public static String expectedResult;
    public static String expectedEmptyResult;
    public static String expectedAllTypesResult;
    public static String expectedSameFilesResult;
    public static String expectedYamlCompareResult;

    @BeforeAll
    public static void setUp() throws IOException {
        Path expectedPath = Paths.get("src/test/resources/expected_result.txt");
        expectedResult = Files.readString(expectedPath).trim();
        Path expectedEmptyPath = Paths.get("src/test/resources/expected_empty.txt");
        expectedEmptyResult = Files.readString(expectedEmptyPath).trim();
        Path expectedAllTypesPath = Paths.get("src/test/resources/expected_all_types.txt");
        expectedAllTypesResult = Files.readString(expectedAllTypesPath).trim();
        Path expectedSameFilesPath = Paths.get("src/test/resources/expected_same_files.txt");
        expectedSameFilesResult = Files.readString(expectedSameFilesPath).trim();
        Path expectedYamlCompareFilesPath = Paths.get("src/test/resources/expected_yaml_files.txt");
        expectedYamlCompareResult = Files.readString(expectedYamlCompareFilesPath).trim();

    }

    @Test
    public void testGenerateFlatJson() throws IOException {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String result = Differ.generate(filePath1, filePath2).trim();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFileNotExist() {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/fileNotExist.json";
        assertThrows(IOException.class, () -> {
            Differ.generate(filePath1, filePath2);
        });
    }

    @Test
    public void testFilesAreEmpty() throws IOException {
        String filePath1 = "src/test/resources/empty_file1.json";
        String filePath2 = "src/test/resources/empty_file2.json";
        String result = Differ.generate(filePath1, filePath2).trim();
        assertEquals(expectedEmptyResult, result);
    }

    @Test
    public void testSameFiles() throws IOException {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file1.json";
        String result = Differ.generate(filePath1, filePath2).trim();
        assertEquals(expectedSameFilesResult, result);
    }

    @Test
    public void testAllTypes() throws IOException {
        String filePath1 = "src/test/resources/file_all_types1.json";
        String filePath2 = "src/test/resources/file_all_types2.json";
        String result = Differ.generate(filePath1, filePath2).trim();
        assertEquals(expectedAllTypesResult, result);
    }

    @Test
    public void testYamlFiles() throws IOException {
        String filePath1 = "src/test/resources/yaml_file1.yaml";
        String filePath2 = "src/test/resources/yaml_file2.yaml";
        String result = Differ.generate(filePath1, filePath2).trim();
        assertEquals(expectedYamlCompareResult, result);
    }

    @Test
    public void testDifferentFormats() throws Exception {
        String filePath1 = "src/test/resources/yaml_file1.yaml";
        String filePath2 = "src/test/resources/file2.json";
        try {
            Differ.generate(filePath1, filePath2).trim();
            assert false : "Must throw exception";
        } catch (IllegalArgumentException e) {
            assertEquals("Files has different format", e.getMessage());
        }
    }
}

