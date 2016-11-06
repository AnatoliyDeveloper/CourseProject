package JavaOOP.CourseProject.filtering;

import JavaOOP.CourseProject.entity.Post;

/**
 * Created by Anatoliy on 05.11.2016.
 */

public class PostStatement {

    private PostStatement() {}

    public static Statement<Post> containsPostText(final String postText) {
        return new Statement<Post>() {
            @Override
            public boolean use(Post elem) {
                return elem.getPostText().toLowerCase().contains(postText.toLowerCase());
            }
        };
    }

    public static Statement<Post> byDate(final int minDate, final int maxDate) {
        return new Statement<Post>() {
            @Override
            public boolean use(Post elem) {
                return elem.getDate() >= minDate && elem.getDate() <= maxDate;
            }
        };
    }
}
