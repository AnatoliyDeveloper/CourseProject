package JavaOOP.CourseProject.filtering;

/**
 * Created by Anatoliy on 05.11.2016.
 */
public class CommonStatement {

    private CommonStatement() {}

    public static <T> Statement<T> allOf(final Statement<T>... statements) {
        return new Statement<T>() {
            @Override
            public boolean use(T elem) {
                for (Statement<T> statement : statements) {
                    if (statement.use(elem)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}
