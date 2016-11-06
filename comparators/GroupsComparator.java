package JavaOOP.CourseProject.comparators;

import JavaOOP.CourseProject.entity.Groups;

import java.util.Comparator;

/**
 * Created by Anatoliy on 28.10.2016.
 */
public class GroupsComparator {

    public static Comparator<Groups> byName(){
        return new Comparator<Groups>() {
            @Override
            public int compare(Groups a, Groups b) {
                return a.getName().compareTo(b.getName());
            }
        };
    }
}
