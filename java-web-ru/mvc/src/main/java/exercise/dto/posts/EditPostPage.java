package exercise.dto.posts;

import java.util.List;
import java.util.Map;

import exercise.model.Post;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// BEGIN
public class EditPostPage {
    private Post post;
    private Map<String, List<ValidationError<Object>>> errors;

    public EditPostPage(Post post){
        this.post = post;
    }
}
// END