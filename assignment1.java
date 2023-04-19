
import java.util.Random;
import java.util.Scanner;

public class assignment1 {
    public static void main(String[] args) {

        Random Generated_Number = new Random();
    
    
    boolean playAgain = true;

    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter your name:");
    String username = scanner.nextLine();
    String GuessAnotherRound;

    // validation to prompt user to input their name before starting the game.
    while (username.length() == 0) {
      System.out.println("Please enter your name:");
      username = scanner.nextLine();
    }
    ;

    System.out.println("Hello " + username + "! Welcome to the guessing game."); // welcome message

    while (playAgain == true) {
      int Number_Of_Trials = 0;
      int Guess_Value;
      int Max_Attempts = 5; // Maximum number of attempts
      int Correct_Guess = Generated_Number.nextInt(10);
      
      for (int i = 1; i <= Max_Attempts; i++) {
        System.out.println("Guess a number between 0 and 10:");
        Guess_Value = scanner.nextInt();
        Number_Of_Trials++;
        // Check if the input the user put is the correct value or not
        // then displays a congratulatory message if he did
        if (Guess_Value == Correct_Guess) {
          System.out.println(
              "Congratulations " + username + "! You rightly guessed the number in " + Number_Of_Trials
                  + " attempt(s)");
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

      System.out.println("Would you like to play again? Type y for 'Yes' and n for 'no'");
      String sc = scanner.nextLine(); //Caters for scanner input lag of nextInt()
      GuessAnotherRound = scanner.nextLine();
      
       if (GuessAnotherRound.equals("y")|| GuessAnotherRound.equals("Y")){
        playAgain = true;
        }
        
        else if( GuessAnotherRound.equals("n") || GuessAnotherRound.equals("N")){
          playAgain = false;
          System.out.println("Thank you for playing " + username);
          break;
        }
        else if(GuessAnotherRound != "n" || GuessAnotherRound != "y"){
          System.out.println("Wrong Character inputted!!!");
          break;
        }
       
    }

    scanner.close();
    }

};
