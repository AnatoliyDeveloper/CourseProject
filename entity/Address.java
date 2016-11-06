package JavaOOP.CourseProject.entity;

import JavaOOP.CourseProject.utils.StringJoiner;

import java.io.Serializable;

/**
 * Created by Anatoliy on 16.10.2016.
 */
public class Address implements Serializable, Entity {

    private static final long serialVersionUID = 4358801747209406971L;

    private String country;
    private String city;
    private String street;

    public Address() {
    }

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!getCountry().equals(address.getCountry())) return false;
        if (!getCity().equals(address.getCity())) return false;
        return getStreet().equals(address.getStreet());

    }

    @Override
    public int hashCode() {
        int result = getCountry().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getStreet().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + "Address { " +
                "country = '" + country + '\'' +
                ", city = '" + city + '\'' +
                ", street = '" + street + '\'' +
                '}';
    }

    @Override
    public String toOutputString(String delimiter) {
        return new StringJoiner(delimiter).join(country, city, street);
    }
}
