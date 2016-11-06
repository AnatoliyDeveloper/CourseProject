package JavaOOP.CourseProject.io;

/**
 * Created by Anatoliy on 06.11.2016.
 */
public class PostValidator {

    public static boolean isDate(long birthday) {
        return birthday >= 1;
    }

    public static boolean isLong(String s){
        try {
            Long.parseLong(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
