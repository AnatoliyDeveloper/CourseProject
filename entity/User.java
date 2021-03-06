package JavaOOP.CourseProject.entity;

import JavaOOP.CourseProject.utils.StringJoiner;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Anatoliy on 08.10.2016.
 */
public class User implements Entity, Serializable {

    private static final long serialVersionUID = 4024841086676875453L;

    private String name;
    private String surname;
    private long birthday;
    private String email;
    private Address address;

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, String surname, long birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public void setBirthday(int day, int month, int year) {
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        Date date = calendar.getTime();
        this.birthday = date.getTime();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getBirthday() != user.getBirthday()) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getSurname().equals(user.getSurname())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        return getAddress().equals(user.getAddress());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getSurname().hashCode();
        result = 31 * result + (int) (getBirthday() ^ (getBirthday() >>> 32));
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getAddress().hashCode();
        return result;
    }

    @Override
    public String toOutputString(String delimiter) {
        return new StringJoiner(delimiter).join(name, surname, birthday, email, address.getCountry(), address.getCity(), address.getStreet());
    }

    @Override
    public String toString() {
        return "\n" + "User { " +
                " name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", birthday = " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date(birthday)) +
                ", email = '" + email + '\'' +
                ", address = " + address +
                '}'+"\n";
    }
}
