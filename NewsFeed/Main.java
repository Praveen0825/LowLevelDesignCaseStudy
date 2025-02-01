package NewsFeed;

public class Main {
    public static void main(String[] args) {
        NewsFeedSystem system = new NewsFeedSystem();
        system.signup("tom");
        system.signup("lucious");
        system.signup("albus");

        system.login("tom");
        system.post("I am going to be the darkest dark wizard of all time");
        system.post("I am lord Voldemort btw 3:)");

        system.login("lucious");
        system.follow("tom");
        system.showNewsFeed();

        system.upvote(1);
        system.reply(1, "I am with you dark lord!");
        system.showNewsFeed();

        system.login("albus");
        system.post("Happiness can be found, even in the darkest of times, if one only remembers to turn on the light");
        system.follow("tom");
        system.downvote(1);
        system.downvote(2);
        system.reply(2, "LOL!");
        system.showNewsFeed();
    }
}
