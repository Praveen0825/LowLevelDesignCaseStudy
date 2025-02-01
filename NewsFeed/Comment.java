package NewsFeed;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    String author;
    String text;
    LocalDateTime timestamp;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public void display() {
        System.out.println("\tComment by " + author + ": " + text);
        System.out.println("\t" + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")));
    }
}
