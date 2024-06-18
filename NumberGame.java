import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("You need to guess a number between " + minRange + " and " + maxRange + ".");
        
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int roundScore = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number correctly in " + attempts + " attempts.");
                    roundScore = maxAttempts - attempts + 1; // Score calculation
                    guessedCorrectly = true;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've exceeded the maximum number of attempts. The correct number was: " + randomNumber);
            }

            totalScore += roundScore;
            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing Number Guessing Game!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Your Total Score: " + totalScore);
    }
}
