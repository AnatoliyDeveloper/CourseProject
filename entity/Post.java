package JavaOOP.CourseProject.entity;

import JavaOOP.CourseProject.utils.StringJoiner;

import java.io.Serializable;

/**
 * Created by Anatoliy on 16.10.2016.
 */
public class Post implements Serializable, Entity {

    private static final long serialVersionUID = 3115515781705938651L;

    private User user;
    private String postText;
    private long date;

    public Post() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (getDate() != post.getDate()) return false;
        if (!getUser().equals(post.getUser())) return false;
        return getPostText().equals(post.getPostText());

    }

    @Override
    public int hashCode() {
        int result = getUser().hashCode();
        result = 31 * result + getPostText().hashCode();
        result = 31 * result + (int) (getDate() ^ (getDate() >>> 32));
        return result;
    }

    @Override
    public String toOutputString(String delimiter) {
        return new StringJoiner(delimiter).join(user.getName(), user.getSurname(), postText, date);
    }

    @Override
    public String toString() {
        return "\n" + "Post { " +
                " user = " + user.getName() + user.getSurname() +
                ", Post text = '" + postText + '\'' +
                ", date = " + date +
                '}'+ "\n" + "\n";
    }
}
