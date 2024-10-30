import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0; // Store total score across rounds
        int round = 1;

        System.out.println("Welcome to the 'Guess the Number' Game!");
        System.out.println("Try to guess the number between 1 and 100.");

        // Game loop for multiple rounds
        while (true) {
            int randomNumber = random.nextInt(100) + 1; // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 7; // Maximum attempts per round
            boolean isGuessed = false;

            System.out.println("\n=== Round " + round + " ===");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            // Loop to guess the number within allowed attempts
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    int points = (maxAttempts - attempts + 1) * 10; // Points based on remaining attempts
                    totalScore += points;
                    System.out.println("You earned " + points + " points this round.");
                    isGuessed = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!isGuessed) {
                System.out
                        .println("Sorry! You've used all your attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your total score so far: " + totalScore);

            // Ask if the player wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
            round++;
        }

        System.out.println("\nGame Over! Your final score is: " + totalScore);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
