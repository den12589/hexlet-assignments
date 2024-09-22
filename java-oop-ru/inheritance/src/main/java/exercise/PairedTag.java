package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String content;
    private List<Tag> tags;

    public PairedTag(String name, Map<String, String> attributes, String content, List<Tag> tags) {
        super(name, attributes);
        this.tags = tags;
        this.content = content;
    }

    @Override
    public String toString() {
        String listTags = tags.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
        return super.toString() + listTags + content + "</" + this.getName() + ">";
    }
}
// END
