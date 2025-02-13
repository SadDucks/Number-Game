import java.util.Scanner;
import java.util.Random;
import javax.naming.event.NamingExceptionEvent;

public class NumGuess{
    public static void main(String [] args){
        //initalizing Scanner + Correct answer
        Scanner userGuess = new Scanner(System.in);
        Random answerRandom = new Random();
        int answer = (answerRandom.nextInt(100) + 1);
    }
}