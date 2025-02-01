package QnASystem;

import java.util.*;

public class QuestionService {
    private List<Question> questions = new ArrayList<>();

    public void askQuestion(String content, Set<String> topics, User user) {
        if (user == null || topics.isEmpty()) {
            throw new RuntimeException("Login required and at least one topic required.");
        }
        questions.add(new Question(content, user.name, topics));
        System.out.println("Question posted successfully.");
    }

    public Question getQuestionById(int id) {
        return questions.stream().filter(q -> q.id == id).findFirst()
                .orElseThrow(() -> new RuntimeException("Question not found."));
    }
}
