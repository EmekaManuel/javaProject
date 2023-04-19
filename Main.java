/*
 * Hacker's World 💻
 */

 import java.util.Scanner;
 import java.util.InputMismatchException;
 
 public class Main {
 
     static class Game {
         public int lives = 5;
         public int score = 0;
         public String password = generateRandomNumber(10);
         final String passwordCopy = password;
         public String[] passwordArr = {"_", "_", "_", "_", "_", "_", "_", "_", "_", "_"};
     }
 
     static String getNumFromUser(Scanner sc) {
         System.out.println("\n Guess a number");
         String n;
         try {
             n = "" + ("" + sc.nextInt()).charAt(0);
         } catch (InputMismatchException e) {
             n = "0";
             sc.next();
         }
         return n;
     }
 
     static void validateNumber(String n, Game game) {
         if (game.password.contains(n)) {
             game.score ++;
             int i = 0;
             while (true) {
                 i = game.passwordCopy.indexOf(n, i);
                 if (i == -1) break;
                 game.passwordArr[i] = n;
                 i++;
             }
             game.password = game.password.replaceAll(n, "");
             System.out.println(consoleColors.green + "Correct Pin" + consoleColors.reset);
             System.out.println(String.join(" ", game.passwordArr));
         } else {
             game.lives--;
             System.out.println(consoleColors.red + "Incorrect Pin" + consoleColors.reset);
         }
     }
 
     static String generateRandomNumber(int n) {
         String s = "";
         int i = 0;
         while (i < n) {
             s = s + ((int) Math.floor(Math.random() * 10));
             i++;
         }
         return s;
     }
 
     static class consoleColors {
         public static String red = "\033[1;31m";
         public static String green = "\033[1;32m";
         public static String reset = "\033[1;0m";
     }
     
     public static void main(String[] args) {
         Game game = new Game();
         Scanner sc = new Scanner(System.in);
         System.out.println("\n\n               Welcome to Hacker World \n\n For your first mission you have been tasked with extracting import documents from a terrorist cell. The file is protected by a 10 digit password. You must crack the password by guessing the numbers one at a time. You only have five attempts before you are discovered and ejected from the server. \nNote: Attempting a number twice will fail and any non-digit character will default to zero. Good Luck Agent. \n\n Lives: 5 \n Password: _ _ _ _ _ _ _ _ _ _");
 
         
         while (game.password.length() > 0 && game.lives > 0) {
             String number = getNumFromUser(sc);
             validateNumber(number, game);
         }
         if (game.lives == 0) {
             System.out.println(consoleColors.red + "Mission Failed. Information Lost" + consoleColors.reset);
         }
         if (game.password.length() == 0) {
             System.out.println(consoleColors.green + "Mission Successful. Weldone" + consoleColors.reset);
         }
         sc.close();
     }
 }
 
 // ❤️❤️❤️❤️❤️