 import java.util.Random;
 import java.util.Scanner;
 
 public class NumGuess{

    public static void welcomeScreen() {
        System.out.println("""
                Welcome! This is the Number Guessing Game
                I will pick a number between 1 and 100; your job is to try and guess it!\n
                How to Play
                -------------
                You type a number between 1-100
                I will tell you if your correct, too low, or too high
                You get 7 guesses total
                """);
    }

    public static int getAnswer(int a) {
        Random answerRandom = new Random();
        return a = (answerRandom.nextInt(100) + 1);
    }

    public static int obtainGuess() {
        Scanner userGuessScanner = new Scanner(System.in);
        return userGuessScanner.nextInt();
    }

    public static boolean gameComplete(boolean yes, int userGuess, int answer, int userAttempt) {
        if(userGuess == answer) {
            System.out.println("CORRECT! You won the game on attempt " + userAttempt);
            return yes = true;
        }
        else {
            return yes = false;
        }
    }

    public static void highOrLow(int userGuess, int answer) {
        if(userGuess > answer) {
            System.out.println("Too high");
        }
        else {
            System.out.println("Too low");
        }
    }

    public static boolean playAgain(boolean done, String answer) {
        System.out.print("Would you like to play again? (Y/N)");
        Scanner userGuessScanner = new Scanner(System.in);

        answer = userGuessScanner.nextLine();
        if(answer.equalsIgnoreCase("Y")) {
            return done = false;
        }
        else {
            System.out.println("Thanks for playing!");
            return done = true;
        }
    }

    public static void statistics(int gameCount, int wins, int losts) {
        System.out.println("Game Statistics:\n");
        System.out.println("Total Games: " + gameCount);
        System.out.println("Wins: " + wins);
        System.out.println("Losts: " + losts);
    }

     public static void main(String [] args){
 
         //Game Finish conditional & Attempt counter
         Boolean done = false;
         Boolean complete = false;
         Boolean win = false;
 
         //Game required variables
         int userAttempt = 1;
         int userGuess;
 
         //Game Satistics
         int gameCount = 1;
         int wins = 0;
         int losts = 0;
 
         //Game Start
         welcomeScreen();

         System.out.println("Lets start!");
 
         //Playing the game
         while(!done) {
             //Win & Lost conditional
             System.out.println("Game " + gameCount);

             //Intialzing scanner & obtaining answer
             Scanner userGuessScanner = new Scanner(System.in);
             int answer = getAnswer(0);
        
             while(!complete) {
                 System.out.print("Current Attempt Count: " + userAttempt + "\nWhat\'s your guess: ");
                 userGuess = obtainGuess(); {
                     //Guess is Correct
                     if(gameComplete(true, userGuess, answer, userAttempt)) {
                         complete = true;
                         win = true;
                         wins++;
                     }
                     //Guess is too high!
                     else {
                         highOrLow(userGuess, answer);
                         userAttempt++;
                     }

                     //Lost
                     if (userAttempt > 7) {
                        System.out.print("Whoops! You lost the game. Would you like to try again? (Y/N) ");
                         complete = true;
                         losts++;
                     }
                 }
             }
             //Play Again
             done = playAgain(false, "");
             if (!done) {
                    gameCount++;
                    userAttempt = 1;
                    complete = false;
                }
         }
         
         //Display Game Statistics
         statistics(gameCount, wins, losts);
     }
 }