package JavaOOP.CourseProject.io;

import JavaOOP.CourseProject.entity.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anatoliy on 06.11.2016.
 */
public class GroupsIOUtils {

    private static BufferedReader reader;

    private GroupsIOUtils() {}

    public static final String CSV_DELIMITER = ";";

    // Input from text file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */

    public static List<Groups> readGroupsesFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readGroupses(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    private static List<Groups> readGroupses(BufferedReader reader) throws IOException {
        GroupsIOUtils.reader = reader;

        List<Groups> res = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Groups groups = parseGroups(line);
            res.add(groups);
        }
        return res;
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Groups readGroupsFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readGroups(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Groups readGroups(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return parseGroups(line);
    }

    // Output into text file

    public static void writeGroupsesIntoFile(String fileName, List<Groups> groupses) throws FileNotFoundException
    {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writeGroupses(writer, groupses);
        }
    }

    public static void writeGroupses(PrintWriter writer, List<Groups> groupses) {
        for (Groups groups : groupses) {
            writer.println(groups.toOutputString(CSV_DELIMITER));
        }
    }

    // Input from binary file

    public static void writeGroupsesIntoBinFile(String fileName, List<Groups> groupses) throws IOException {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutput.writeObject(groupses);
        }
    }

    // Output into binary file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Groups> readGroupsesFromBinFile(String fileName) throws IOException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Groups>)objectInput.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IllegalFormatException("Binary file is corrupted", e);
        }
    }

    // Common

    /**
     * @throws IllegalFormatException
     */

    private static Groups parseGroups(String line) {
        String[] tokens = line.split(CSV_DELIMITER);

        if (tokens.length < 3) {
            throw new IllegalFormatException("Missing values, should be (name;description): " + line);
        }

        Groups groups = new Groups();
        groups.setName(tokens[0]);
        groups.setDescription(tokens[1]);

        return groups;
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
