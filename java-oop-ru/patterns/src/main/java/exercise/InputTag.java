package exercise;

import lombok.Getter;

// BEGIN
@Getter
public class InputTag implements TagInterface {
    private String type;
    private String value;

    @Override
    public String render() {
        return "<input type=\"" + type + "\" value=\"" + value + "\">";
    }

    public InputTag(String type, String value) {
        this.type = type;
        this.value = value;
    }
}
// END
