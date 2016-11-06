package JavaOOP.CourseProject.io;

import JavaOOP.CourseProject.entity.Post;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static JavaOOP.CourseProject.io.PostValidator.isDate;
import static JavaOOP.CourseProject.io.UserValidator.isLong;

/**
 * Created by Anatoliy on 06.11.2016.
 */
public class PostIOUtils {

    private PostIOUtils() {}

    public static final String CSV_DELIMITER = ";";

    // Input from text file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */

    public static List<Post> readPostsFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readPosts(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    private static List<Post> readPosts(BufferedReader reader) throws IOException {

        List <Post> res = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Post post = parsePost(line);
            res.add(post);
        }
        return res;
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Post readPostFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readPost(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Post readPost(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return parsePost(line);
    }

    // Output into text file

    public static void writePostsIntoFile(String fileName, List<Post> posts) throws FileNotFoundException
    {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writePosts(writer, posts);
        }
    }

    public static void writePosts(PrintWriter writer, List<Post> posts) {
        for (Post post : posts) {
            writer.println(post.toOutputString(CSV_DELIMITER));
        }
    }

    // Input from binary file

    public static void writePostsIntoBinFile(String fileName, List<Post> posts) throws IOException {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutput.writeObject(posts);
        }
    }

    // Output into binary file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Post> readPostsFromBinFile(String fileName) throws IOException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Post>)objectInput.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IllegalFormatException("Binary file is corrupted", e);
        }
    }

    // Common

    /**
     * @throws IllegalFormatException
     */

    private static Post parsePost(String line) {
        String[] tokens = line.split(CSV_DELIMITER);

        if (tokens.length < 2) {
            throw new IllegalFormatException("Missing values, should be (postText;date): " + line);
        }

        Post post = new Post();
        post.setPostText(tokens[0]);
        post.setDate(parseDate(tokens[1]));

        return post;
    }

    private static long parseDate(String s) {
        if (!isLong(s)) {
            throw new IllegalFormatException("Illegal date: " + s);
        }
        Long date = Long.parseLong(s);
        if (!isDate(date)) {
            throw new IllegalFormatException("Date should be min 1: " + s);
        }
        return date;
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
