package JavaOOP.CourseProject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anatoliy on 10.10.2016.
 */
public class Groups implements Serializable {

    private static final long serialVersionUID = -7025256154546158696L;

    private String name;
    private String description;
    private List <User> users = new ArrayList<>();
    private List <Post> posts = new ArrayList<>();

    public Groups() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Groups)) return false;

        Groups groups = (Groups) o;

        if (!getName().equals(groups.getName())) return false;
        if (!getDescription().equals(groups.getDescription())) return false;
        if (!getUsers().equals(groups.getUsers())) return false;
        return getPosts().equals(groups.getPosts());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getUsers().hashCode();
        result = 31 * result + getPosts().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + "Groups { " +
                " name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", users = " + users +
                ", posts = " + posts +
                '}';
    }
}
