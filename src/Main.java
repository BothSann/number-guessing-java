import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

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

        }
    }

    private static int generateRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}