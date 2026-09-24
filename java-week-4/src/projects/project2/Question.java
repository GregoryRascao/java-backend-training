// 2. **Online Quiz System** ❓

//    * Classes: `Question`, `ChoiceQuestion`, `TrueFalseQuestion`.
//    * Store questions in a `List<Question>`.
//    * Use **polymorphism**: `displayQuestion()` overridden in each subclass.
//    * Features: ask questions, check answers, calculate score.

package projects.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Question {
    private String text;

    public Question(String text) {
        this.text = text;
    }

    public String getQuestion() {
        return text;
    }

    public abstract void displayQuestion();

    public abstract boolean checkAnswer(String answer);

    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        questions.add(new TrueFalseQuestion("Java supports object-oriented programming.", true));
        questions.add(new ChoiceQuestion("Which language is used to create Android applications?",
                Arrays.asList("Java", "HTML", "SQL", "CSS"), "Java"));
        questions.add(new ChoiceQuestion("Which keyword is used to inherit from a class in Java?",
                Arrays.asList("implements", "extends", "inherits", "super"),
                "extends"));

                        int score = 0;

        System.out.println("===== ONLINE QUIZ =====");

        for (Question question : questions) {
            System.out.println();

            // Le type réel de la question détermine la méthode appelée.
            question.displayQuestion();

            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (question.checkAnswer(answer)) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }
        }

        System.out.println();
        System.out.println("===== RESULT =====");
        System.out.println("Your score: " + score + "/" + questions.size());

        scanner.close();
    }
}
