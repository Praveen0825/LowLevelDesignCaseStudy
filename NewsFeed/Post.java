package NewsFeed;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    static int postIdCnt=1;
    int id;
    String author;
    String content;
    int upvotes;
    int downvotes;
    LocalDateTime timestamp;
    List<Comment> comments;

    public Post(String author, String content) {
        this.id = postIdCnt++;
        this.author = author;
        this.content = content;
        this.upvotes = 0;
        this.downvotes = 0;
        this.timestamp = LocalDateTime.now();
        this.comments = new ArrayList<>();
    }

    public int getScore() {
        return upvotes - downvotes;
    }

    public void upvote() {
        upvotes++;
    }

    public void downvote() {
        downvotes++;
    }

    public void addComment(String author, String text) {
        comments.add(new Comment(author, text));
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("(" + upvotes + " upvotes, " + downvotes + " downvotes)");
        System.out.println(author);
        System.out.println(content);
        System.out.println(timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")));
        for (Comment comment : comments) {
            comment.display();
        }
        System.out.println();
    }
}
