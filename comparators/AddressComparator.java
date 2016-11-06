package JavaOOP.CourseProject.comparators;

import JavaOOP.CourseProject.entity.Address;

import java.util.Comparator;

/**
 * Created by Anatoliy on 28.10.2016.
 */
public class AddressComparator {

    public AddressComparator() {}

    public static Comparator<Address> byCountry(){
        return new Comparator<Address>(){
            @Override
            public int compare(Address a, Address b) {
                return a.getCountry().compareTo(b.getCountry());
            }
        };
    }

    public static Comparator<Address> byCity(){
        return new Comparator<Address>(){
            @Override
            public int compare(Address a, Address b) {
                return a.getCity().compareTo(b.getCity());
            }
        };
    }

    public static Comparator<Address> byStreet(){
        return new Comparator<Address>(){
            @Override
            public int compare(Address a, Address b) {
                return a.getStreet().compareTo(b.getStreet());
            }
        };
    }
}
