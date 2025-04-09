import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static int totalGamesPlayed = 0;
    private static int minGuesses = Integer.MAX_VALUE;
    private static int maxGuesses = 0;
    private static int totalGuesses = 0;


    public static void main(String[] args) {
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            playGame();
            playAgain = askToPlayAgain();
        }
    }

    private static void playGame() {
        int minRange = 1;
        int maxRange = 100;
        int targetNumber = generateRandomNumber(minRange, maxRange);
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\n--- New Game ---");
        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ">_<");
        System.out.println("Try to guess it! >_<");


        while (!guessedCorrectly) {
            int guess = getValidGuess(minRange, maxRange);
            attempts++;

            if (guess < targetNumber) System.out.println("Close, but too low! Try again. >_<");
            if (guess > targetNumber) System.out.println("Omg no! Too high! Try again. >_<");
            if (guess == targetNumber) {
                guessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + targetNumber + " correctly in " + attempts + " attempts! >_<");

                totalGamesPlayed++;
                totalGuesses+= attempts;
                minGuesses = Math.min(minGuesses, attempts);
                maxGuesses = Math.max(maxGuesses, attempts);
            }
        }
    }

    private static int generateRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    private static int getValidGuess(int min, int max) {
        int guess = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your guess (" + min + " - " + max + "): ");
            try {
                guess = scanner.nextInt();
                if (guess < min || guess > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }

        return guess;
    }
}