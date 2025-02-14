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
        int gameCount = 1;

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
                System.out.print("Current Attempt Count: " + userAttempt + "\nWhats your guess: ");
                userGuess = userGuessScanner.nextInt(); {
                    //Guess is Correct
                    if(userGuess == answer) {
                        complete = true;
                        win = true;
                        userGuessScanner.nextLine();
                    }
                    //Guess is too high!
                    else if(userGuess > answer) {
                        System.out.println("You answer is too high!");
                        userAttempt++;
                    }
                    //Guess is too low!
                    else if (userGuess < answer) {
                        System.out.println("You answer is too low!");
                        userAttempt++;
                    }
                    //Lost
                    if (userAttempt > 7) {
                        complete = true;
                        lost = true;
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
                    lost = false;
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
                    userGuess = 0;
                    complete = false;
                    win = false;
                    gameCount++;
                }

                else if (doneInput.equals("N")) {
                    System.out.println("Thanks for playing");
                    done = true;
                    userGuessScanner.close();
                }
                else {
                    System.out.println("Thanks for playing");
                    done = true;
                    userGuessScanner.close();
                }
            }
        }
    }
}