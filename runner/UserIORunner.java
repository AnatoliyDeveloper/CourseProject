package JavaOOP.CourseProject.runner;

import JavaOOP.CourseProject.entity.Groups;
import JavaOOP.CourseProject.entity.Post;
import JavaOOP.CourseProject.entity.User;
import JavaOOP.CourseProject.io.IllegalFormatException;

import java.io.IOException;
import java.util.List;

import static JavaOOP.CourseProject.io.PostIOUtils.*;
import static JavaOOP.CourseProject.io.UserIOUtils.*;
import static JavaOOP.CourseProject.io.GroupsIOUtils.*;

/**
 * Created by Anatoliy on 06.11.2016.
 */
public class UserIORunner {

    public static final String INPUT_FILE_USER = "files/user/users.csv";
    public static final String OUTPUT_FILE_USER = "files/user/users.out";
    public static final String BIN_FILE_USER = "files/user/users.dat";

    public static final String INPUT_FILE_POST = "files/post/posts.csv";
    public static final String OUTPUT_FILE_POST = "files/post/posts.out";
    public static final String BIN_FILE_POST = "files/post/posts.dat";

    public static final String INPUT_FILE_GROUPS = "files/groups/groups.csv";
    public static final String OUTPUT_FILE_GROUPS = "files/groups/groups.out";
    public static final String BIN_FILE_GROUPS = "files/groups/groups.dat";

    public static void main(String[] args) throws IOException {
        try {
            List<User> users = readUsersFromFile(INPUT_FILE_USER);
            writeUsersIntoFile(OUTPUT_FILE_USER, users);
            writeUsersIntoBinFile(BIN_FILE_USER, users);
            System.out.println("Ready");
        } catch (IOException e) {
            System.out.println("Sorry, IO Error exists. " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
        }

        try {
            List<Post> posts = readPostsFromFile(INPUT_FILE_POST);
            writePostsIntoFile(OUTPUT_FILE_POST, posts);
            writePostsIntoBinFile(BIN_FILE_POST, posts);
            System.out.println("Ready");
        } catch (IOException e) {
            System.out.println("Sorry, IO Error exists. " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
        }

        try {
            List<Groups> groupses = readGroupsesFromFile(INPUT_FILE_GROUPS);
            writeGroupsesIntoFile(OUTPUT_FILE_GROUPS, groupses);
            writeGroupsesIntoBinFile(BIN_FILE_GROUPS, groupses);
            System.out.println("Ready");
        } catch (IOException e) {
            System.out.println("Sorry, IO Error exists. " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalFormatException e) {
            System.out.println("Illegal format. " + e.getMessage());
        }
    }
}
