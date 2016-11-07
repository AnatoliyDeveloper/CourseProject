package JavaOOP.CourseProject.io;

import JavaOOP.CourseProject.entity.Address;
import JavaOOP.CourseProject.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static JavaOOP.CourseProject.io.UserValidator.isBirthday;
import static JavaOOP.CourseProject.io.UserValidator.isLong;

/**
 * Created by Anatoliy on 05.11.2016.
 */
public class UserIOUtils {

    private UserIOUtils() {}

    public static final String CSV_DELIMITER = ";";

    // Input from text file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */

    public static List<User> readUsersFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readUsers(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    private static List<User> readUsers(BufferedReader reader) throws IOException {

        List <User> res = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            User user = parseUser(line);
            res.add(user);
        }
        return res;
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static User readUserFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readUser(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static User readUser(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return parseUser(line);
    }

    // Output into text file

    public static void writeUsersIntoFile(String fileName, List<User> users) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writeUsers(writer, users);
        }
    }

    public static void writeUsers(PrintWriter writer, List<User> users) {
        for (User user : users) {
            writer.println(user.toOutputString(CSV_DELIMITER));
        }
    }

    // Input from binary file

    public static void writeUsersIntoBinFile(String fileName, List<User> users) throws IOException {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutput.writeObject(users);
        }
    }

    // Output into binary file

    /**
     * @throws IOException
     * @throws IllegalFormatException
    */
    public static List<User> readUsersFromBinFile(String fileName) throws IOException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<User>)objectInput.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IllegalFormatException("Binary file is corrupted", e);
        }
    }

    // Common

    /**
     * @throws IllegalFormatException
     */

    private static User parseUser(String line) {
        String[] tokens = line.split(CSV_DELIMITER);
        Address address = new Address();

        if (tokens.length < 7) {
            throw new IllegalFormatException("Missing values, should be (name;surname;birthday;email;country;city;street): " + line);
        }

        User user = new User();
        user.setName(tokens[0]);
        user.setSurname(tokens[1]);
        user.setBirthday(parseBirthday(tokens[2]));
        user.setEmail(tokens[3]);
        address.setCountry(tokens[4]);
        address.setCity(tokens[5]);
        address.setStreet(tokens[6]);
        user.setAddress(address);

        return user;
    }

    private static long parseBirthday(String s) {
        if (!isLong(s)) {
            throw new IllegalFormatException("Illegal Birthday: " + s);
        }
        long birthday = Long.parseLong(s);
        if (!isBirthday(birthday)) {
            throw new IllegalFormatException("Birthday should be min 1: " + s);
        }
        return birthday;
    }

    public static void closeReader(BufferedReader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
