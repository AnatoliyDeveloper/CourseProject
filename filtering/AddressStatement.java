package JavaOOP.CourseProject.filtering;

import JavaOOP.CourseProject.entity.Address;

/**
 * Created by Anatoliy on 05.11.2016.
 */

public class AddressStatement {

    private AddressStatement() {
    }

    public static Statement<Address> containsCountry(final String country) {
        return new Statement<Address>() {
            @Override
            public boolean use(Address elem) {
                return elem.getCountry().toLowerCase().contains(country.toLowerCase());
            }
        };
    }

    public static Statement<Address> containsCity(final String city) {
        return new Statement<Address>() {
            @Override
            public boolean use(Address elem) {
                return elem.getCity().toLowerCase().contains(city.toLowerCase());
            }
        };
    }

    public static Statement<Address> containsStreet(final String street) {
        return new Statement<Address>() {
            @Override
            public boolean use(Address elem) {
                return elem.getStreet().toLowerCase().contains(street.toLowerCase());
            }
        };
    }
}
