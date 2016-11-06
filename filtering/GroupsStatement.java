package JavaOOP.CourseProject.filtering;

import JavaOOP.CourseProject.entity.Groups;

/**
 * Created by Anatoliy on 05.11.2016.
 */

public class GroupsStatement {

    public static Statement<Groups> containsName(final String name) {
        return new Statement<Groups>() {
            @Override
            public boolean use(Groups elem) {
                return elem.getName().toLowerCase().contains(name.toLowerCase());
            }
        };
    }

    public static Statement<Groups> containsDescription(final String description) {
        return new Statement<Groups>() {
            @Override
            public boolean use(Groups elem) {
                return elem.getDescription().toLowerCase().contains(description.toLowerCase());
            }
        };
    }
}
