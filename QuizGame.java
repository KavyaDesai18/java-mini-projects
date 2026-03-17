import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args){

        String[] questions = { "Who is the best test captain of india?" ,
                                "What is the highest score of virat kohli?" ,
                                "When we last time born the t20 world cup?" ,
                                "Who won the IPL last year?" ,
                                "For how many years CSK gets banned in ipl?"};

        //options is 2D array because it will have multiple options for each particular questions
        // so first array for accessing the particular question and second for options for that particular questions
        String[][] options = {  {"Rohit Sharma" , "Virat Kohli" , "KL Rahul" , "Risabh pant"} ,
                                {"254" , "183" , "269" , "154"} ,
                                {"2001" , "2005" , "2024" , "2007"} ,
                                {"RCB" , "MI" , "RR" , "SRH"} ,
                                {"10" , "6" , "5" , "2"}
                            };

        //it is the answer key of each questions
        int[] answer = { 2 , 1 , 3 , 1 , 4};
        int score = 0;
        int guess;
        int k =1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************************");
        System.out.println("welcome to the QUIZ Game");
        System.out.println("*****************************");

        for(int i =0; i< questions.length;i++ ){ //for displaying the questions.
            System.out.println("\n"  + questions[i] + "\n");

            for(String option : options[i]){   //for displaying the option of that question
                System.out.println( k + ". " + option);
                k++;
            }

            System.out.print("Enet your guess option(1-4):");
            guess = scanner.nextInt();

            if(guess>4 || guess <1){
                System.out.println("Please select the valid options between 1 to 4");
            }
            else{

                //for checking the answer of each question with guess
                if(guess == answer[i]){
                    System.out.println("*************");
                    System.out.println("CORRECT");
                    System.out.println("*************");
                    score++;
                }
                else{
                    System.out.println("*************");
                    System.out.println("WRONG!!");
                    System.out.println("*************");
                }
            }
        }
        System.out.println("\nScore = " + score);

        if(score == 0){
            System.out.println("\nyou're absolute looser!!");
        }

        else if (score == 5) {
            System.out.println("\nYou're a CHAMPION!!");
        }

        else{
            System.out.println("\nTry hard next time");
        }

        scanner.close();
    }
}
