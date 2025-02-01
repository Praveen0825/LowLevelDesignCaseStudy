package QnASystem;

import java.util.*;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    private User loggedInUser = null;

    public void registerUser(String name, String profession) {
        users.put(name, new User(name, profession));
    }

    public void login(String username) {
        if (!users.containsKey(username)) {
            throw new RuntimeException("User not found.");
        }
        loggedInUser = users.get(username);
        loggedInUser.login();
        System.out.println(username + " logged in.");
    }

    public void logout() {
        if (loggedInUser != null) {
            loggedInUser.logout();
            System.out.println(loggedInUser.name + " logged out.");
            loggedInUser = null;
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
