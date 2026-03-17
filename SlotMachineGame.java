import java.util.Random;
import java.util.Scanner;

public class SlotMachineGame {

    static double balance = 100.00;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Are you want to play java slots game? ( yes or no):");
        String wantToPlay = scanner.nextLine().toLowerCase();
        while(!wantToPlay.equals("no")){
            if(wantToPlay.equals("yes") || wantToPlay.equals("y")){
                game();
            }
            else {
                System.out.print("Please be clear are you want to play or not? (yes or no):");
                continue;
            }
            System.out.print("\n\nYou want to play Again?");
            wantToPlay = scanner.nextLine();
        }
        System.out.println("Thank You !");
        System.out.println("Current Balance = " + balance);

        scanner.close();
    }

    static void game(){

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        System.out.println("\n************************");
        System.out.println("Welcome to java slots");
        System.out.println("************************\n");

        String[] symbols = { "🍒", "🍋", "🍌", "🍎", "⭐" };

        System.out.print("Symbols = ");
        for (String symbol : symbols){
            System.out.print(symbol + " ");
        }

        System.out.println("\nCurrent Balance : " + balance);

        System.out.print("\nplace your bet amount: ");
        double betAmount = scanner.nextDouble();
        if(betAmount > balance){
            System.out.println("bet amount is greater than your current balance!");
            return;
        }

        balance -= betAmount;

        System.out.println("Spinning....finger crossed 🤞\n");

        String value1 = symbols[random.nextInt(0,4)];
        String value2 = symbols[random.nextInt(0,4)];
        String value3 = symbols[random.nextInt(0,4)];

        System.out.println("*************");
        System.out.println(value1 + " | " + value2 + " | " + value3 + " | ");
        System.out.println("*************");
        if(value1.equals(value2) || value1.equals(value3) || value2.equals(value3) ){
            System.out.println("\nCongratulations!! ");
            System.out.printf("\nYou won %.2f in this round!!" , betAmount*5);
            balance+=(betAmount*5);
        }
        else {
            System.out.println("Soryy you lost in this round!!\n");
            System.out.println("Try again!");
        }
    }
}


