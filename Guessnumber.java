import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowBound = 1;
        int upBound = 100;
        int Number = random.nextInt(upBound - lowBound + 1) + lowBound;

        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + lowBound + " and " + upBound);
        System.out.println("You have 4 attempts to guess the number");
        while (attempts<4 && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < Number) {
                System.out.println("please enter a higher number.");
            } else if (userGuess > Number) {
                System.out.println("please enter a lower number.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println(" You've guessed the number " + Number);
                System.out.println("Your score is : "+attempts);
            }
        }
        if (!hasGuessedCorrectly) {
            System.out.println("Try again");
        }
        scanner.close();
    }
}
