package exercise;

import lombok.Getter;

// BEGIN
@Getter
public class LabelTag implements TagInterface {
    private String label;
    private TagInterface tagInterface;

    @Override
    public String render() {
        return "<label>Press Submit" + tagInterface.render() + "</label>";
    }

    public LabelTag(String label, TagInterface tagInterface) {
        this.label = label;
        this.tagInterface = tagInterface;
    }
}
// END
