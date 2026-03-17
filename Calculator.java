import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);

       double first;
       double second;
        System.out.print("\nEnter the first number:");
        first = scanner.nextDouble();

        System.out.print("\nEnter an operator ( +, - , * , / , ^ , %):");
        String operation = scanner.next();

        System.out.print("\nEnter the second number:");
        second = scanner.nextDouble();
        if(second == 0 && operation.equals("/")){
            System.out.println("you cannot divide number by Zero!");
        }

        switch (operation){
            case "+" -> System.out.println("Addition :" + (first + second));
            case "-" -> System.out.println("Substraction:" + (first - second));
            case "*" -> System.out.println("Multiplication:" + (first * second));
            case "/" ->
                System.out.println("Division:" + (first / second));
            case "^" -> System.out.println(Math.pow(first , second));
            case "%" -> System.out.println("Modulo:" + (first % second));

            default -> {
                System.out.println("Are you mad!!");
                System.out.println("Please enter a valid operator!!");
            }
        }

       scanner.close();
    }
}
