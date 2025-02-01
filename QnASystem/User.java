package QnASystem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class User {
    String name;
    String profession;
    boolean isLoggedIn;
    Set<String> subscribedTopics;

    public User(String name, String profession) {
        this.name = name;
        this.profession = profession;
        this.isLoggedIn = false;
        this.subscribedTopics = new HashSet<>();
    }

    public void login() {
        this.isLoggedIn = true;
    }

    public void logout() {
        this.isLoggedIn = false;
    }

    public void subscribe(String topic) {
        subscribedTopics.add(topic.toLowerCase());
    }

    public void unsubscribe(String topic) {
        subscribedTopics.remove(topic.toLowerCase());
    }
}
