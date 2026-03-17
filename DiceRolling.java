import java.util.Scanner;
import java.util.Random;

public class DiceRolling {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfDice;
        int total = 0;
        System.out.print("Enter the number of dice you want to roll :");
        numberOfDice = scanner.nextInt();

        if (numberOfDice > 0){

            for(int i=0; i < numberOfDice ; i++){
                int roll = random.nextInt(1,7);
                System.out.printf("\nYou roll : %d" , roll);
                total += roll;
            }
            System.out.println("\n\nTotal = " + total);
        }
        else{
            System.out.println("please enter a valid dice number!");
            System.out.println("please enter a dice number greater than Zero!");
        }
        scanner.close();
    }
}
