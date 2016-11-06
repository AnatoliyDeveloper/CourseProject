package JavaOOP.CourseProject.comparators;

import JavaOOP.CourseProject.entity.Post;

import java.util.Comparator;

/**
 * Created by Anatoliy on 28.10.2016.
 */
public class PostComparator {

    public static Comparator<Post> byDate(){
        return new Comparator<Post>(){
            @Override
            public int compare(Post a, Post b) {
                return Long.compare(a.getDate(), b.getDate());
            }
        };
    }
}
