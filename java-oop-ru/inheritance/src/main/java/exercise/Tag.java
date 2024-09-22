package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
@Getter
@AllArgsConstructor
public class Tag {
    private String name;
    private Map<String, String> attributes;

    @Override
    public String toString() {
        String mapper = "";
        if (!getAttributes().isEmpty()) {
            mapper = " " + this.getAttributes().entrySet().stream()
                    .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                    .collect(Collectors.joining(" "));
        }
        return "<" + this.getName() + mapper + ">";
    }
}
// END
