import java.util.Random;
import java.util.Scanner;
public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 10;
        boolean playAgain = true;

        while (playAgain) {
            int attempts = playRound(rangeStart, rangeEnd, maxAttempts, scanner);
            System.out.println("You took " + attempts + " attempts.");

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static int generateNumber(int rangeStart, int rangeEnd) {
        Random random = new Random();
        return random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
    }

    public static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int playRound(int rangeStart, int rangeEnd, int maxAttempts, Scanner scanner) {
        int targetNumber = generateNumber(rangeStart, rangeEnd);
        int attempts = 0;

        while (attempts < maxAttempts) {
            int guess = getUserGuess(scanner);
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                return attempts;
            } else if (guess < targetNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
        return maxAttempts + 1;
    }
}
