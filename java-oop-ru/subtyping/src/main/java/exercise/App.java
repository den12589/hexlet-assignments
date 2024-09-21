package exercise;

import java.util.Map;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {
        Map.copyOf(keyValueStorage.toMap()).forEach((key, value) -> {
            keyValueStorage.set(value, key);
            keyValueStorage.unset(key);
        });
    }
}
// END
