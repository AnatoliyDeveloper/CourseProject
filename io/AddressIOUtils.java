package JavaOOP.CourseProject.io;

import JavaOOP.CourseProject.entity.Address;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anatoliy on 06.11.2016.
 */
public class AddressIOUtils {

    private static BufferedReader reader;

    private AddressIOUtils() {}

    public static final String CSV_DELIMITER = ";";

    // Input from text file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */

    public static List<Address> readAddressesFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readAddresses(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    private static List<Address> readAddresses(BufferedReader reader) throws IOException {
        AddressIOUtils.reader = reader;

        List <Address> res = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Address address = parseAddress(line);
            res.add(address);
        }
        return res;
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Address readAddressFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return readAddress(reader);
        }
    }

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static Address readAddress(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return parseAddress(line);
    }

    // Output into text file

    public static void writeAddressesIntoFile(String fileName, List<Address> addresses) throws FileNotFoundException
    {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writeAddresses(writer, addresses);
        }
    }

    public static void writeAddresses(PrintWriter writer, List<Address> addresses) {
        for (Address address : addresses) {
            writer.println(address.toOutputString(CSV_DELIMITER));
        }
    }

    // Input from binary file

    public static void writeAddressesIntoBinFile(String fileName, List<Address> addresses) throws IOException {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutput.writeObject(addresses);
        }
    }

    // Output into binary file

    /**
     * @throws IOException
     * @throws IllegalFormatException
     */
    public static List<Address> readAddressesFromBinFile(String fileName) throws IOException {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Address>)objectInput.readObject();
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IllegalFormatException("Binary file is corrupted", e);
        }
    }

    // Common

    /**
     * @throws IllegalFormatException
     */

    private static Address parseAddress(String line) {
        String[] tokens = line.split(CSV_DELIMITER);

        if (tokens.length < 3) {
            throw new IllegalFormatException("Missing values, should be (country;city;street): " + line);
        }

        Address address = new Address();
        address.setCountry(tokens[0]);
        address.setCity(tokens[1]);
        address.setStreet(tokens[2]);

        return address;
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
