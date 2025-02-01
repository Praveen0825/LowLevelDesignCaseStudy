package QnASystem;

import java.util.Collections;

public class AnswerService {
    public void answerQuestion(Question question, String answerContent, User user) {
        if (user == null) {
            throw new RuntimeException("Login required.");
        }
        if (Collections.disjoint(user.subscribedTopics, question.topics)) {
            throw new RuntimeException("You must subscribe to a topic before answering.");
        }
        question.addAnswer(new Answer(answerContent, user.name));
        System.out.println("Answer posted successfully.");
    }

    public void upvoteAnswer(Question question, int answerIndex) {
        if (answerIndex >= question.answers.size()) {
            throw new RuntimeException("Invalid answer index.");
        }
        question.answers.get(answerIndex).upvote();
        System.out.println("Answer upvoted successfully.");
    }
}
