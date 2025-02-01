package QnASystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class Question {
    static int idCounter = 1;
    int id;
    String content;
    String author;
    Set<String> topics;
    List<Answer> answers;
    Date timestamp;

    public Question(String content, String author, Set<String> topics) {
        this.id = idCounter++;
        this.content = content;
        this.author = author;
        this.topics = topics;
        this.answers = new ArrayList<>();
        this.timestamp = new Date();
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answers.sort(Comparator.comparingInt(a -> -a.votes)); // Sort answers by votes
    }

}
