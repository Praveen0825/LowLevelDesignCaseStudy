package NewsFeed;

import java.util.*;

public class User {
    String username;
    Set<String> following;
    List<Post> posts;

    public User(String username) {
        this.username = username;
        this.following = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    public void follow(String user) {
        following.add(user);
    }

    public void post(String content) {
        posts.add(new Post(username, content));
    }
}
