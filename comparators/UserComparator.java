package JavaOOP.CourseProject.comparators;

import JavaOOP.CourseProject.entity.User;

import java.util.Comparator;

/**
 * Created by Anatoliy on 28.10.2016.
 */
public class UserComparator {

    private UserComparator() {}

    public static Comparator<User> byBirthday() {
        return new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return Long.compare(a.getBirthday(), b.getBirthday());
            }
        };
    }

    public static Comparator<User> byName() {
        return new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return a.getName().compareTo(b.getName());
            }
        };
    }

    public static Comparator<User> bySurname() {
        return new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return a.getSurname().compareTo(b.getSurname());
            }
        };
    }

    public static Comparator<User> byEmail() {
        return new Comparator<User>() {
            @Override
            public int compare(User a, User b) {
                return a.getEmail().compareTo(b.getEmail());
            }
        };
    }
}






