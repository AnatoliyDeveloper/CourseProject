package JavaOOP.CourseProject.utils;

import java.util.List;

/**
 * Created by Anatoliy on 01.11.2016.
 */
public class PrintList {

    public PrintList() {
    }

    public static <E> void printList (List <E> list) {
        for (E elem : list) {
            System.out.println(elem);
        }
    }
}
