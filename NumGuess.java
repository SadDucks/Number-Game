import java.util.Random;
import java.util.Scanner;

public class NumGuess{
    public static void main(String [] args){
        //initalizing Scanner + Correct answer
        Scanner userGuessScanner = new Scanner(System.in);
        Random answerRandom = new Random();
        int answer = (answerRandom.nextInt(100) + 1);
        Boolean done = false;
        int userAttempt = 1;
        int userGuess;

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
        System.out.print("Lets start!");

        while(!done && userAttempt <= 7) {
            System.out.print("Whats your guess: ");
            userGuess = userGuessScanner.nextInt(); {
                if (userGuess == answer) {
                    System.out.println("CORRECT! You won the game on attempt " + userAttempt);
                    done = true;
                }
                else if(userGuess > answer) {
                    System.out.println("You answer is too low!");
                    userAttempt++;
                }
            }
        }
    }
}