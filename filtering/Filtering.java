package JavaOOP.CourseProject.filtering;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anatoliy on 01.11.2016.
 */
public class Filtering {

    private Filtering() {
    }

    public static <T> List<T> filtering(List<T> elems, Statement<T> statement) {

        List<T> search = new ArrayList<>();

        for (T elem : elems) {
            if (statement.use(elem)) {
                search.add(elem);
            }
        }

        return search;
    }
}
