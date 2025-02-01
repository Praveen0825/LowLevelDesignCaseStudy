package NewsFeed;

import java.util.*;
import java.util.List;
import java.util.Map;

public class NewsFeedSystem {
    Map<String,User> users;
    List<Post> globalPosts;
    String loggedInUser;
    public NewsFeedSystem() {
        this.users = new HashMap<>();
        this.globalPosts = new ArrayList<>();
        this.loggedInUser = null;
    }

    public void signup(String username) {
        if (users.containsKey(username)) {
            System.out.println("Username already taken!");
        } else {
            users.put(username, new User(username));
            System.out.println("User " + username + " signed up successfully.");
        }
    }

    public void login(String username) {
        if (!users.containsKey(username)) {
            System.out.println("User does not exist!");
        } else {
            loggedInUser = username;
            System.out.println(username + " logged in.");
            showNewsFeed();
        }
    }

    public void post(String content) {
        if (loggedInUser == null) {
            System.out.println("Login first!");
            return;
        }
        users.get(loggedInUser).post(content);
        globalPosts.add(new Post(loggedInUser, content));
    }

    public void follow(String userToFollow) {
        if (loggedInUser == null || !users.containsKey(userToFollow)) {
            System.out.println("Invalid user or not logged in!");
            return;
        }
        users.get(loggedInUser).follow(userToFollow);
        System.out.println(loggedInUser + " is now following " + userToFollow);
    }

    public void upvote(int postId) {
        for (Post post : globalPosts) {
            if (post.id == postId) {
                post.upvote();
                return;
            }
        }
        System.out.println("Post not found!");
    }

    public void downvote(int postId) {
        for (Post post : globalPosts) {
            if (post.id == postId) {
                post.downvote();
                return;
            }
        }
        System.out.println("Post not found!");
    }

    public void reply(int postId, String text) {
        for (Post post : globalPosts) {
            if (post.id == postId) {
                post.addComment(loggedInUser, text);
                return;
            }
        }
        System.out.println("Post not found!");
    }

    public void showNewsFeed() {
        if (loggedInUser == null) {
            System.out.println("Login first!");
            return;
        }
        List<Post> feed = new ArrayList<>(globalPosts);
        feed.sort((p1, p2) -> {
            boolean p1Followed = users.get(loggedInUser).following.contains(p1.author);
            boolean p2Followed = users.get(loggedInUser).following.contains(p2.author);
            if (p1Followed && !p2Followed) return -1;
            if (!p1Followed && p2Followed) return 1;
            if (p2.getScore() != p1.getScore()) return Integer.compare(p2.getScore(), p1.getScore());
            if (p2.comments.size() != p1.comments.size()) return Integer.compare(p2.comments.size(), p1.comments.size());
            return p2.timestamp.compareTo(p1.timestamp);
        });

        for (Post post : feed) {
            post.display();
        }
    }
}
