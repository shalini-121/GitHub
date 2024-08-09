import java.util.Scanner;

public class QuizApplication {
    private static final String[] QUESTIONS = {
        "What is the capital of France?",
        "What is the largest planet in our solar system?",
        "Who wrote Romeo and Juliet?"
    };

    private static final String[][] ANSWERS = {
        {"Paris", "London", "Berlin", "Rome"},
        {"Jupiter", "Saturn", "Uranus", "Neptune"},
        {"William Shakespeare", "Jane Austen", "Leo Tolstoy", "F. Scott Fitzgerald"}
    };

    private static final int[] CORRECT_ANSWERS = {0, 0, 0};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < QUESTIONS.length; i++) {
            System.out.println(QUESTIONS[i]);
            for (int j = 0; j < ANSWERS[i].length; j++) {
                System.out.println((j + 1) + ". " + ANSWERS[i][j]);
            }
            System.out.print("Enter the number of your answer: ");
            int answer = scanner.nextInt() - 1;
            if (answer == CORRECT_ANSWERS[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was " + ANSWERS[i][CORRECT_ANSWERS[i]]);
            }
        }

        System.out.println("Your final score is " + score + " out of " + QUESTIONS.length);
    }
}