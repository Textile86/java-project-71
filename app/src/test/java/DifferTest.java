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
    private static String expectedResult;
    private static String expectedEmptyResult;
    private static String expectedAllTypesResult;
    private static String expectedSameFilesResult;
    private static String expectedYamlCompareResult;
    private static String expectedNestedCompareResult;
    private static String expectedNestedPlainCompareResult;
    private static String expectedPlainFlatJsonResult;
    private static String expectedJsonformFlatResult;
    private static String expectedJsonformNestedResult;


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
        Path expectedNestedCompareFilesPath = Paths.get("src/test/resources/expected_nested_result.txt");
        expectedNestedCompareResult = Files.readString(expectedNestedCompareFilesPath).trim();
        Path expectedNestedPlainFilesPath = Paths.get("src/test/resources/expected_nested_plain_result.txt");
        expectedNestedPlainCompareResult = Files.readString(expectedNestedPlainFilesPath).trim();
        Path expectedPlainFlatJsonFilesPath = Paths.get("src/test/resources/expected_plain_flat_json.txt");
        expectedPlainFlatJsonResult = Files.readString(expectedPlainFlatJsonFilesPath).trim();
        Path  expectedJsonformFlatFilesPath = Paths.get("src/test/resources/expected_jsonform_flat.txt");
        expectedJsonformFlatResult = Files.readString(expectedJsonformFlatFilesPath).trim();
        Path  expectedJsonformNestedFilesPath = Paths.get("src/test/resources/expected_jsonform_nested.txt");
        expectedJsonformNestedResult = Files.readString(expectedJsonformNestedFilesPath).trim();
    }

    @Test
    public void testGenerateFlatJson() throws IOException {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFileNotExist() {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/fileNotExist.json";
        assertThrows(IOException.class, () -> Differ.generate(filePath1, filePath2, "stylish"));

    }

    @Test
    public void testFilesAreEmpty() throws IOException {
        String filePath1 = "src/test/resources/empty_file1.json";
        String filePath2 = "src/test/resources/empty_file2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedEmptyResult, result);
    }

    @Test
    public void testSameFiles() throws IOException {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file1.json";
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedSameFilesResult, result);
    }

    @Test
    public void testAllTypes() throws IOException {
        String filePath1 = "src/test/resources/file_all_types1.json";
        String filePath2 = "src/test/resources/file_all_types2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedAllTypesResult, result);
    }

    @Test
    public void testYamlFiles() throws IOException {
        String filePath1 = "src/test/resources/yaml_file1.yaml";
        String filePath2 = "src/test/resources/yaml_file2.yaml";
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedYamlCompareResult, result);
    }

    @Test
    public void testDifferentFormats() {
        String filePath1 = "src/test/resources/yaml_file1.yaml";
        String filePath2 = "src/test/resources/file2.json";
        Exception e = assertThrows(RuntimeException.class, () -> Differ.generate(filePath1, filePath2, "stylish"));
        assertEquals("Files has different format", e.getMessage());
    }


    @Test
    public void testNestedJsonFiles() throws IOException {
        String filePath1 = "src/test/resources/nested_json_file1.json";
        String filePath2 = "src/test/resources/nested_json_file2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedNestedCompareResult, result);
    }

    @Test
    public void testNestedYamlFiles() throws IOException {
        String filePath1 = "src/test/resources/nested_yaml_file1.yaml";
        String filePath2 = "src/test/resources/nested_yaml_file2.yaml";
        String result = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedNestedCompareResult, result);
    }

    @Test
    public void testNestedPlainFiles() throws IOException {
        String filePath1 = "src/test/resources/nested_yaml_file1.yaml";
        String filePath2 = "src/test/resources/nested_yaml_file2.yaml";
        String result = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(expectedNestedPlainCompareResult, result);
    }

    @Test
    public void testGeneratePlainFlatJson() throws IOException {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String result = Differ.generate(filePath1, filePath2, "plain");
        assertEquals(expectedPlainFlatJsonResult, result);
    }

    @Test
    public void testPlainFileNotExist() {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/fileNotExist.json";
        assertThrows(IOException.class, () -> Differ.generate(filePath1, filePath2, "plain"));
    }

    @Test
    public void testPlainDifferentFormats() {
        String filePath1 = "src/test/resources/yaml_file1.yaml";
        String filePath2 = "src/test/resources/file2.json";
        Exception e = assertThrows(RuntimeException.class, () -> Differ.generate(filePath1, filePath2, "plain"));
        assertEquals("Files has different format", e.getMessage());
    }

    @Test
    public void testPlainUnknownFormat() {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        assertThrows(RuntimeException.class, () -> Differ.generate(filePath1, filePath2, "unknown"));
    }

    @Test
    public void testGenerateJsonformFlat() throws IOException {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";
        String result = Differ.generate(filePath1, filePath2, "json");
        assertEquals(expectedJsonformFlatResult, result);
    }

    @Test
    public void testGenerateJsonformNested() throws IOException {
        String filePath1 = "src/test/resources/nested_json_file1.json";
        String filePath2 = "src/test/resources/nested_json_file2.json";
        String result = Differ.generate(filePath1, filePath2, "json");
        assertEquals(expectedJsonformNestedResult, result);
    }

    @Test
    public void testJsonformDifferentFormats() {
        String filePath1 = "src/test/resources/yaml_file1.yaml";
        String filePath2 = "src/test/resources/file2.json";
        Exception e = assertThrows(RuntimeException.class, () -> Differ.generate(filePath1, filePath2, "json"));
        assertEquals("Files has different format", e.getMessage());
    }

    @Test
    public void testJsonformFileNotExist() {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/fileNotExist.json";
        assertThrows(IOException.class, () -> Differ.generate(filePath1, filePath2, "json"));
    }

}
