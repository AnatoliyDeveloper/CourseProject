package JavaOOP.CourseProject.runner;

import JavaOOP.CourseProject.entity.Address;
import JavaOOP.CourseProject.entity.Groups;
import JavaOOP.CourseProject.entity.Post;
import JavaOOP.CourseProject.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anatoliy on 21.10.2016.
 */
public class SocialNetworkRunner {

    public static void main(String[] args) {

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();

        user1.setName("Ivan");
        user1.setSurname("Lucian");
        user1.setBirthday(8, 3, 1989);
        user1.setEmail("ivan@gmail.com");
        user1.setAddress(new Address("Ukraine", "Kiev", "Kharkov highway"));

        user2.setName("Johnny");
        user2.setSurname("Depp");
        user2.setBirthday(9, 06, 1963);
        user2.setEmail("johnny@depp.com");
        user2.setAddress(new Address("USA", "Los Angeles", "Wilshire Blvd"));

        user3.setName("Viktor");
        user3.setSurname("Frankenshteyn");
        user3.setBirthday(31, 12, 1800);
        user3.setEmail("viktor@frankenshteyn.com");
        user3.setAddress(new Address("Romania", "Transylvania", "Vampire street"));

        user4.setName("Vin");
        user4.setSurname("Diesel");
        user4.setBirthday(18, 7, 1967);
        user4.setEmail("vin@diesel.com");
        user4.setAddress(new Address("USA", "Los Angeles", "East Kensington Road"));

        user5.setName("Merry");
        user5.setSurname("Christmas");
        user5.setBirthday(25, 12, 1);
        user5.setEmail("merry@christmas.com");
        user5.setAddress(new Address("England", "London", "Oxford street"));

        List <User> stars = new ArrayList<>();
        stars.add(user2);
        stars.add(user3);
        stars.add(user4);

        List <User> ukraineGroup = new ArrayList<>();
        ukraineGroup.add(user1);

        List <User> christmasGroup = new ArrayList<>();
        christmasGroup.add(user4);
        christmasGroup.add(user5);

        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();
        Post post4 = new Post();

        post1.setUser(user2);
        post1.setDate(10, 10, 2016);
        post1.setPostText("Hey. I'm Johnny Depp, also known as Jack Sparrow... How's tricks?");

        post2.setUser(user3);
        post2.setDate(21, 12, 2012);
        post2.setPostText("Hey Ya. How are you? I am Victor Frankenstein. That I revived the very monster. Ha ha ha !!!");

        post3.setUser(user1);
        post3.setDate(8, 8, 2012);
        post3.setPostText("Hello. I am Lucian Ivan. Regular guy from Kiev. Where are you from?");

        post4.setUser(user5);
        post4.setDate(7, 11, 2016);
        post4.setPostText("Hey. I'm Merry. Merry Christmas. Happy you!!!");

        List <Post> postsGroup1 = new ArrayList<>();
        postsGroup1.add(post1);
        postsGroup1.add(post2);

        List <Post> postsGroup2 = new ArrayList<>();
        postsGroup2.add(post3);

        List <Post> postsGroup3 = new ArrayList<>();
        postsGroup3.add(post4);

        Groups group1 = new Groups();
        Groups group2 = new Groups();
        Groups group3 = new Groups();

        group1.setName("Star blue screens");
        group1.setDescription("Then came all the famous actors");
        group1.setUsers(stars);
        group1.setPosts(postsGroup1);

        group2.setName("Ukraine group");
        group2.setDescription("Our little flock of the Gypsies");
        group2.setUsers(ukraineGroup);
        group2.setPosts(postsGroup2);

        group3.setName("Christmas soon");
        group3.setDescription("The holiday is approaching!");
        group3.setUsers(christmasGroup);
        group3.setPosts(postsGroup3);

        List<Groups> groups = new ArrayList<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);

        System.out.println(groups);
    }
}
