package QnASystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        QuestionService questionService = new QuestionService();
        AnswerService answerService = new AnswerService();

        userService.registerUser("john", "developer");
        userService.registerUser("alice", "data scientist");

        userService.login("john");
        User user = userService.getLoggedInUser();
        user.subscribe("java");

        questionService.askQuestion("What is Java?", new HashSet<>(Arrays.asList("java")), user);
        Question question = questionService.getQuestionById(1);
        answerService.answerQuestion(question, "Java is a programming language.", user);
        answerService.upvoteAnswer(question, 0);

        userService.logout();
    }
}

