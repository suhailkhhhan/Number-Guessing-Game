// Number Guessing Game 
import java.util.Random;
import java.util.Scanner;
public class Task2 {
    static int min = 1;
    static int max = 100;
    static int max_attempts = 10;
    static int max_rounds = 3;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int total_score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Total number of rounds: " + max_rounds);
        System.out.println("Total number of attempts per round: " + max_attempts);

        for (int i = 1; i <= max_rounds; i++) {
            int number = random.nextInt(max - min + 1) + min; 
            int attempts = 0;
            int round_score = 0;

            System.out.println("\nRound " + i + ": Guess the number between " + min + " and " + max);

            while (attempts < max_attempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    round_score = max_attempts - attempts + 1; // Score based on attempts left
                    total_score += round_score;
                    System.out.println(" Congratulations! You guessed the number in " + attempts + " attempts.");
                    break;
                } else if (guess < number) {
                    System.out.println("The number is **greater** than " + guess + ". Attempts left: " + (max_attempts - attempts));
                } else {
                    System.out.println("The number is **less** than " + guess + ". Attempts left: " + (max_attempts - attempts));
                }
            }

            if (attempts == max_attempts) {
                System.out.println("\n Round " + i + " over! You've used all attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Your score for this round: " + round_score);
            System.out.println("Your total score so far: " + total_score);
        }

        System.out.println("\n Game Over! Your final total score is: " + total_score);
        sc.close(); 
    }
}
