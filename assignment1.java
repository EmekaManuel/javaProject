
import java.util.Random;
import java.util.Scanner;

public class assignment1 {
    public static void main(String[] args) {

        Random Generated_Number = new Random();
        int Correct_Guess = Generated_Number.nextInt(10);
        int Number_Of_Trials = 0;
        int Guess_Value; // The correct answer 
        int Max_Attempts = 5; // Maximum number of attempts

        System.out.primtln("This is a Guessing Game. You will be asked to Guess a number five times.");
        System.out.println(" If you get number correctly, you get a point, if not you get nothing");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String username = scanner.nextLine();

        // validation to prompt user to input their name before starting the game.
        while (username.length() == 0) {
            System.out.println("Please enter your name:");
            username = scanner.nextLine();
        };

        System.out.println("Hello " + username + "! Welcome to the guessing game."); //welcome message

        for (int i = 1; i <= Max_Attempts; i++) {
            System.out.println("Guess a number between 0 and 10:");
            Guess_Value = scanner.nextInt();
            Number_Of_Trials++;
// Check if the input the user put is the correct value or not
            // then displays a congratulatory message if he did 
            if (Guess_Value == Correct_Guess) {
                System.out.println(
                        "Congratulations " + username + "! You rightly guessed the number in " + Number_Of_Trials + " attempt(s)");
                break;
            } else if (Guess_Value < Correct_Guess) {
                System.out.println("Your guess is too low");
            } else {
                System.out.println("Your guess is too high");
            }

            // Check if the user has used all the attempts
            if (i == Max_Attempts) {
                System.out.println("Sorry, " + username + ", you didn't guess the number in " + Max_Attempts
                        + " attempts. The correct number was " + Correct_Guess);
            }
        }

        scanner.close();
    }

};
