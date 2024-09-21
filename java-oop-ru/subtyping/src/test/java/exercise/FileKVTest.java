package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void FileMethodsTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "10"));
        assertEquals(storage.get("key", "def"), "10");
        assertEquals(storage.get("ke2", "def"), "def");

        storage.set("key2", "value2");
        storage.set("key", "value");

        assertEquals(storage.get("key", "def"), "value");
        assertEquals(storage.get("key2", "def"), "value2");

        storage.unset("key");

        assertEquals(storage.get("key", "def"), "def");
        assertEquals(storage.toMap(), Map.of("key2", "value2"));
    }
    // END
}
