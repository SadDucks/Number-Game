/***************************
 *                         *
 * NumGuess.java           *
 * A Number Guessing Game  *
 *                         *
 * By Jacub Truong         *
 *                         *
 ***************************/




import java.util.Random;
import java.util.Scanner;

public class NumGuess{
    public static void main(String [] args){
        //Correct answer
        Random answerRandom = new Random();
        int answer = (answerRandom.nextInt(100) + 1);
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
        System.out.println("""
                Welcome! This is the Number Guessing Game
                I will pick a number between 1 and 100; your job is to try and guess it!\n
                How to Play
                -------------
                You type a number between 1-100
                I will tell you if your correct, too low, or too high
                You get 7 guesses total
                """);
        System.out.println("Lets start!");

        //Playing the game
        while(!done) {
            //Win & Lost conditional
            System.out.println("Game " + gameCount);
            Boolean lost = false;
            //Intialzing scanner
            Scanner userGuessScanner = new Scanner(System.in);
       
            while(!complete) {
                System.out.print("Current Attempt Count: " + userAttempt + "\nWhat\'s your guess: ");
                userGuess = userGuessScanner.nextInt(); {
                    //Guess is Correct
                    if(userGuess == answer) {
                        complete = true;
                        win = true;
                        wins++;
                        userGuessScanner.nextLine();
                    }
                    //Guess is too high!
                    else if(userGuess > answer) {
                        System.out.println("You answer is too high!");
                        userAttempt++;
                    }
                    //Guess is too low!
                    else {
                        System.out.println("You answer is too low!");
                        userAttempt++;
                    }
                    //Lost
                    if (userAttempt > 7) {
                        complete = true;
                        lost = true;
                        losts++;
                        userGuessScanner.nextLine();
                    }
                }
            }
            //End screen lost
            if (lost == true) {
                System.out.print("Whoops! You lost the game. Would you like to try again? (Y/N) ");
                String doneInput; 
                doneInput = userGuessScanner.nextLine();

                if (doneInput.equals("Y")) {
                    userAttempt = 1;
                    userGuess = 0;
                    complete = false;
                    answer = (answerRandom.nextInt(100) + 1);
                    gameCount++;
                }

                else if (doneInput.equals("N")) {
                    System.out.println("Thanks for playing");
                    done = true;
                }
                else {
                    System.out.println("Thanks for playing");
                    done = true;
                }
            }
            //End Screen Win
            if (win == true) {
                System.out.println("CORRECT! You won the game on attempt " + userAttempt);
                System.out.print("Would you like to try again? (Y/N) ");
                String doneInput; 
                doneInput = userGuessScanner.nextLine();

                if (doneInput.equals("Y")) {
                    userAttempt = 1;
                    complete = false;
                    win = false;
                    answer = (answerRandom.nextInt(100) + 1);
                    gameCount++;
                }

                else if (doneInput.equals("N")) {
                    System.out.println("\nThanks for playing");
                    done = true;
                    userGuessScanner.close();
                }
                else {
                    System.out.println("\nThanks for playing");
                    done = true;
                    userGuessScanner.close();
                }
            }
        }
        //Display Game Statistics
        System.out.println("\nGame Statistics:\n");
        System.out.println("Total Games: " + gameCount);
        System.out.println("Wins: " + wins);
        System.out.println("Losts: " + losts);
    }
}