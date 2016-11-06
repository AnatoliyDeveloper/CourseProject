package JavaOOP.CourseProject.runner;

import JavaOOP.CourseProject.entity.User;

import java.util.ArrayList;
import java.util.List;
import static JavaOOP.CourseProject.comparators.GeneralComparator.twoCriterias;
import static JavaOOP.CourseProject.comparators.UserComparator.byBirthday;
import static JavaOOP.CourseProject.comparators.UserComparator.byName;
import static JavaOOP.CourseProject.comparators.UserComparator.bySurname;
import static JavaOOP.CourseProject.utils.PrintList.printList;
import static java.util.Collections.sort;

/**
 * Created by Anatoliy on 01.11.2016.
 */
public class SortingRunner {

    public static void main(String[] args) {

        List <User> users = createUsers();

        sort(users, (byName()));
        printList(users);
        System.out.println();

        sort(users, (bySurname()));
        printList(users);
        System.out.println();

        sort(users, (byBirthday()));
        printList(users);
        System.out.println();

        sort(users, twoCriterias((byName()), bySurname()));
        printList(users);
        System.out.println();
    }

    private static List<User> createUsers() {
        List <User> users = new ArrayList<>();
        users.add(new User("Vasiliy", "Kot", 1234567890));
        users.add(new User("Petro", "Sobaka", 1876543210));
        users.add(new User("Fedor", "Popygay", 345678912));
        return users;
    }
}
