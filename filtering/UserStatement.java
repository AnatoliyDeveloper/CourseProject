package JavaOOP.CourseProject.filtering;

import JavaOOP.CourseProject.entity.User;

/**
 * Created by Anatoliy on 05.11.2016.
 */
public class UserStatement {

    private UserStatement() {
    }

    public static Statement<User> containsName(final String name) {
        return new Statement<User>() {
            @Override
            public boolean use(User elem) {
                return elem.getName().toLowerCase().contains(name.toLowerCase());
            }
        };
    }

    public static Statement<User> containsSurname(final String surname) {
        return new Statement<User>() {
            @Override
            public boolean use(User elem) {
                return elem.getName().toLowerCase().contains(surname.toLowerCase());
            }
        };
    }

    public static Statement<User> byBirthday(final int minBirthday, final int maxBirthday) {
        return new Statement<User>() {
            @Override
            public boolean use(User elem) {
                return elem.getBirthday() >= minBirthday && elem.getBirthday() <= maxBirthday;
            }
        };
    }

    public static Statement<User> containsEmail(final String email) {
        return new Statement<User>() {
            @Override
            public boolean use(User elem) {
                return elem.getEmail().toLowerCase().contains(email.toLowerCase());
            }
        };
    }
}
