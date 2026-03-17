import java.util.Random;
import java.util.Scanner;


public class GuessGame {
    public static void main(String[] args){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int guess;
        int attempts = 3;
        int randomNumber = random.nextInt(1,11); //generate between 1 to 10.

        System.out.println("You have only 3 attemots to guess the correct number!!");
        do {
            System.out.println("\nMake a guess between 1 to 10:");
            guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("\nCongratulations..!! you guess the correct number!");
            }
            else {
                System.out.println("\nWrong Answer!!");
                System.out.println("Guess again..\n");
                attempts--;
            }

        }while (attempts != 0);
        System.out.println("ohhhh...sorry you have no attempts are left!");
        System.out.println("You lost the game!!");
        System.out.println("Better luck next time..🤞");

    }
}
