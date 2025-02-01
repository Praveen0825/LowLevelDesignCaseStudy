package QnASystem;

import java.time.LocalDateTime;

public class Answer {
    String content;
    String author;
    int votes;

    public Answer(String content, String author) {
        this.content = content;
        this.author = author;
        this.votes = 0;
    }

    public void upvote() {
        this.votes++;
    }
}
