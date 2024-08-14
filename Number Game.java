import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;
        int roundsPlayed = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have 10 attempts to guess the number.");

            while (attempts < 10 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    totalScore += (10 - attempts + 1); // Scoring based on attempts
                    roundsWon++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've used all attempts! The correct number was " + numberToGuess);
            }

            roundsPlayed++;
            System.out.println("Your current score: " + totalScore);
            System.out.println("Rounds won: " + roundsWon + " out of " + roundsPlayed);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score: " + totalScore);
        System.out.println("Rounds won: " + roundsWon + " out of " + roundsPlayed);
        scanner.close();
    }
}