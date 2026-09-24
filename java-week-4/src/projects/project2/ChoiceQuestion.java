// 2. **Online Quiz System** ❓

//    * Classes: `Question`, `ChoiceQuestion`, `TrueFalseQuestion`.
//    * Store questions in a `List<Question>`.
//    * Use **polymorphism**: `displayQuestion()` overridden in each subclass.
//    * Features: ask questions, check answers, calculate score.

package projects.project2;

import java.util.*;

public class ChoiceQuestion extends Question {
    private List<String> choices;
    private String correctAnswer;

    public ChoiceQuestion(String text, List<String> choices, String correctAnswer) {
        super(text);
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayQuestion() {
        System.out.println(getQuestion());

        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i));
        }
    };

    @Override
    public boolean checkAnswer(String answer) {
        int selectedChoice;
        try {
            selectedChoice = Integer.parseInt(answer);
            String selectedAnswer = choices.get(selectedChoice -1 );
            return selectedAnswer.equalsIgnoreCase(selectedAnswer);
        } catch (Exception e) {
            return false;
        }
    }

}
