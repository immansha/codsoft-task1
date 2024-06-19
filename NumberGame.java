import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int score = 0;

        System.out.println("Welcome to the Number  Game!");

        do {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess it.");

            for (int attempts = 1; attempts <= attemptsLimit; attempts++) {
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    score += attempts;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
                }
            }

            System.out.print(" you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();

            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                break;
            }
        } while (true);

        System.out.println("Game Over. Your total score is: " + score);
        scanner.close();
    }
}
