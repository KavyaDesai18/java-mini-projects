import java.util.Scanner;

public class BankingProgram {

    static double balance = 28756.98;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************");
        System.out.println("BANKING PROGRAM");
        System.out.println("*****************");

        System.out.println("1. Show Balance \n2. Deposit \n3. Withdraw \n4. Exit" );
        int choice = 0;
        do {
            System.out.print("\n\nEnter your choice (1-4):");

             choice = scanner.nextInt();


            switch (choice) {
                case 1 -> System.out.println(showBalance());
                case 2 -> Deposit();
                case 3 -> withdraw();
                case 4 -> exit();
                default -> System.out.println("please enter a valid choice");
            }
        } while (choice != 4);
    }

    static double showBalance(){
        System.out.println("Your account Balance is:");
        return balance;
    }

    static void Deposit(){
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("Enter amount you want to deposit:");
        double amount = scanner1.nextDouble();
        if(amount > 5000){
            System.out.println("you cannot deposit more than 5000 at once!🤬");
        }
        else {
            System.out.print(amount + " amount deposited successfully!\n");
            balance += amount;
            System.out.printf("Current Balance: %.2f" , balance);
        }

    }

    static void withdraw(){
        Scanner scanner2 = new Scanner(System.in);

        System.out.print("Enter amount you want to Withdraw:");
        double amount = scanner2.nextDouble();
        if (amount >= (balance - 100.00)) {
            System.out.println("You cannot withdraw full amount!");
        }
        else {
            System.out.print(amount + " amount withdraw successfully!\n");
            balance -= amount;
            System.out.printf("Current Balance: %.2f" , balance);
        }

    }

    static void exit(){
        System.out.println("Thank you for using our banking program!");
    }
}
