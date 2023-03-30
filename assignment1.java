
import java.util.Random;
import java.util.Scanner;

public class assignment1 {
    public static void main(String[] args) {

        Random generatedNumber = new Random();
        int correctGuess = generatedNumber.nextInt(10);
        int numberOfTrials = 0;
        int guessValue;
        int maxAttempts = 3; // Maximum number of attempts

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String username = scanner.nextLine();

        // validation to prompt user to input their name before starting the game.
        while (username.length() == 0) {
            System.out.println("Please enter your name:");
            username = scanner.nextLine();
        };

        System.out.println("Hello " + username + ", welcome to the guessing game"); //welcome message

        for (int i = 1; i <= maxAttempts; i++) {
            System.out.println("Guess a number between 0 and 10:");
            guessValue = scanner.nextInt();
            numberOfTrials++;

            if (guessValue == correctGuess) {
                System.out.println(
                        "Congratulations " + username + "! You guessed the number in " + numberOfTrials + " attempt");
                break;
            } else if (guessValue < correctGuess) {
                System.out.println("Your guess is too low");
            } else {
                System.out.println("Your guess is too high");
            }

            // Check if the user has used all the attempts
            if (i == maxAttempts) {
                System.out.println("Sorry, " + username + ", you didn't guess the number in " + maxAttempts
                        + " attempts. The correct number was " + correctGuess);
            }
        }

        scanner.close();
    }

};