package JavaOOP.CourseProject.io;

/**
 * Created by Anatoliy on 05.11.2016.
 */
public class UserValidator {

    private UserValidator(){}

    public static boolean isBirthday(long birthday) {
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

    public static boolean isInt(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
