import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorGame {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAre you Want to play ROCK PAPER SCISSORS GAME (yes or no):");
        String wantToPlay = scanner.nextLine().toLowerCase();

        while (!wantToPlay.equals("no")) {

            if (wantToPlay.equals("yes")) {
                game();
            }
            else {
                System.out.print("please be clear are you want to play or not?");
            }

            System.out.print("\nAre you Want to play Again? (yes or no): ");
            wantToPlay = scanner.nextLine().toLowerCase();
        }

        System.out.println("Thank you!");
        scanner.close();
    }

    static void game(){

        Scanner scanner1 = new Scanner(System.in); // new scanner created
        Random random = new Random();

        String[] choice = {"rock", "paper", "scissors"};

        System.out.print("Enter your Move (rock, paper, scissors): ");
        String userChoice = scanner1.nextLine().toLowerCase();

        if(!userChoice.equals("rock") &&
                !userChoice.equals("paper") &&
                !userChoice.equals("scissors")) {

            System.out.println("Please enter a valid move!!");
            return; //go to the main method if user enter a invalid choice!
        }

        String computerChoice = choice[random.nextInt(3)];
        //this will generate the random number between 0 to 2 and computer choice will be choice[0,1,2] anyone of it
        //for example if random generates 1 so choice[1] is paper.

        System.out.println("Computer Choice = " + computerChoice);

        if(userChoice.equals(computerChoice)){
            System.out.println("Tie!");
        }
        else if (userChoice.equals("rock") && computerChoice.equals("scissors") ||
                userChoice.equals("paper") && computerChoice.equals("rock") ||
                userChoice.equals("scissors") && computerChoice.equals("paper")) {

            System.out.println("You Win!");
        }
        else {
            System.out.println("You lose!");
        }

    }
}
