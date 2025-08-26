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
    public static String expectedNestedCompareResult;
    public static String expectedNestedPlainCompareResult;
    public static String expectedPlainFlatJsonResult;


    @BeforeAll
    public static void setUp() throws IOException {
        Path expectedPath = Paths.get("expected_result.txt");
        expectedResult = Files.readString(expectedPath).trim();
        Path expectedEmptyPath = Paths.get("expected_empty.txt");
        expectedEmptyResult = Files.readString(expectedEmptyPath).trim();
        Path expectedAllTypesPath = Paths.get("expected_all_types.txt");
        expectedAllTypesResult = Files.readString(expectedAllTypesPath).trim();
        Path expectedSameFilesPath = Paths.get("expected_same_files.txt");
        expectedSameFilesResult = Files.readString(expectedSameFilesPath).trim();
        Path expectedYamlCompareFilesPath = Paths.get("expected_yaml_files.txt");
        expectedYamlCompareResult = Files.readString(expectedYamlCompareFilesPath).trim();
        Path expectedNestedCompareFilesPath = Paths.get("expected_nested_result.txt");
        expectedNestedCompareResult = Files.readString(expectedNestedCompareFilesPath).trim();
        Path expectedNestedPlainFilesPath = Paths.get("expected_nested_plain_result.txt");
        expectedNestedPlainCompareResult = Files.readString(expectedNestedPlainFilesPath).trim();
        Path expectedPlainFlatJsonFilesPath = Paths.get("expected_plain_flat_json.txt");
        expectedPlainFlatJsonResult = Files.readString(expectedPlainFlatJsonFilesPath).trim();
    }

    @Test
    public void testGenerateFlatJson() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish").trim();
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFileNotExist() {
        String filePath1 = "file1.json";
        String filePath2 = "fileNotExist.json";
        assertThrows(IOException.class, () -> {
            Differ.generate(filePath1, filePath2, "stylish");
        });
    }

    @Test
    public void testFilesAreEmpty() throws IOException {
        String filePath1 = "empty_file1.json";
        String filePath2 = "empty_file2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish").trim();
        assertEquals(expectedEmptyResult, result);
    }

    @Test
    public void testSameFiles() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file1.json";
        String result = Differ.generate(filePath1, filePath2, "stylish").trim();
        assertEquals(expectedSameFilesResult, result);
    }

    @Test
    public void testAllTypes() throws IOException {
        String filePath1 = "file_all_types1.json";
        String filePath2 = "file_all_types2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish").trim();
        assertEquals(expectedAllTypesResult, result);
    }

    @Test
    public void testYamlFiles() throws IOException {
        String filePath1 = "yaml_file1.yaml";
        String filePath2 = "yaml_file2.yaml";
        String result = Differ.generate(filePath1, filePath2, "stylish").trim();
        assertEquals(expectedYamlCompareResult, result);
    }

    @Test
    public void testDifferentFormats() throws Exception {
        String filePath1 = "yaml_file1.yaml";
        String filePath2 = "file2.json";
        try {
            Differ.generate(filePath1, filePath2, "stylish").trim();
            assert false : "Must throw exception";
        } catch (IllegalArgumentException e) {
            assertEquals("Files has different format", e.getMessage());
        }
    }

    @Test
    public void testNestedJsonFiles() throws IOException {
        String filePath1 = "nested_json_file1.json";
        String filePath2 = "nested_json_file2.json";
        String result = Differ.generate(filePath1, filePath2, "stylish").trim();
        assertEquals(expectedNestedCompareResult, result);
    }

    @Test
    public void testNestedYamlFiles() throws IOException {
        String filePath1 = "nested_yaml_file1.yaml";
        String filePath2 = "nested_yaml_file2.yaml";
        String result = Differ.generate(filePath1, filePath2, "stylish").trim();
        assertEquals(expectedNestedCompareResult, result);
    }

    @Test
    public void testNestedPlainFiles() throws IOException {
        String filePath1 = "nested_yaml_file1.yaml";
        String filePath2 = "nested_yaml_file2.yaml";
        String result = Differ.generate(filePath1, filePath2, "plain").trim();
        assertEquals(expectedNestedPlainCompareResult, result);
    }

    @Test
    public void testGeneratePlainFlatJson() throws IOException {
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        String result = Differ.generate(filePath1, filePath2, "plain").trim();
        assertEquals(expectedPlainFlatJsonResult, result);
    }

    @Test
    public void testPlainFileNotExist() {
        String filePath1 = "file1.json";
        String filePath2 = "fileNotExist.json";
        assertThrows(IOException.class, () -> {
            Differ.generate(filePath1, filePath2, "plain");
        });
    }

    @Test
    public void testPlainDifferentFormats() throws Exception {
        String filePath1 = "yaml_file1.yaml";
        String filePath2 = "file2.json";
        try {
            Differ.generate(filePath1, filePath2, "plain").trim();
            assert false : "Must throw exception";
        } catch (IllegalArgumentException e) {
            assertEquals("Files has different format", e.getMessage());
        }
    }

    @Test
    public void testPlainUnknownFormat() {
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";
        assertThrows(IllegalArgumentException.class, () -> {
            Differ.generate(filePath1, filePath2, "unknown");
        });
    }



}

