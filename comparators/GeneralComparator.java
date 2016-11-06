package JavaOOP.CourseProject.comparators;

import java.util.Comparator;

/**
 * Created by Anatoliy on 01.11.2016.
 */
public class GeneralComparator {

    private GeneralComparator() {}

    public static <T> Comparator<T> twoCriterias(final Comparator<T>... comparators) {
        return new Comparator<T>() {
            @Override
            public int compare(T a, T b) {
                for (Comparator<T> comparator : comparators) {
                    int compare = comparator.compare(a, b);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return 0;
            }
        };
    }
}
