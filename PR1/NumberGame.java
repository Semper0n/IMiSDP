import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private final int secretNumber;

    public NumberGame() {
        Random rand = new Random();
        this.secretNumber = rand.nextInt(100) + 1;
    }

    public String guess(int number) {
        if (number < secretNumber) {
            return "Too low! Try again.";
        } else if (number > secretNumber) {
            return "Too high! Try again.";
        } else {
            return "Congratulations! You guessed the number.";
        }
    }

    public static void main(String[] args) {
        NumberGame game = new NumberGame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("A random number between 1 and 100 has been chosen. Try to guess it!");

        int guess = -1;
        while (guess != game.secretNumber) {
            System.out.print("Enter your guess: ");

            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                System.out.println(game.guess(guess));
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 100.");
                scanner.next(); // очистка некорректного ввода
            }
        }

        scanner.close();
    }
}