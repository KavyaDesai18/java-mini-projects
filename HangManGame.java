import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangManGame {

    public static void main(String[] args){

        String filePath = "src\\words.txt";     //for getting the path of a file
        ArrayList<String> words = new ArrayList<>();  //for storing the file words

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){  //read the file line by line
            String line;                        //for checking weather the file has more words or not

            //read line will return null if there is no more word to read in file
            while ((line = reader.readLine()) != null){   //that's why we check that
                words.add(line.trim());              //to trim the extra spacing in file after each word
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File is not found!");
        }
        catch (IOException e){
            System.out.println("Something went wrong!");
        }

        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));     //To get the random word from given file.

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> list = new ArrayList<>();
        int wrongGuesses = 0;

        for(int i = 0; i < word.length() ; i++){
            list.add('_');
        }

        System.out.println("**********************************");
        System.out.println("WELCOME TO THE JAVA HANGMAN GAME!");
        System.out.println("**********************************");

        while (wrongGuesses < 6) {              // used for playing the game until the chance is get finished

            System.out.print(getHangmanResult(wrongGuesses));

            System.out.print("WORD : ");

            for(char c:list){                //for accessing each character of word in list
                System.out.print(c + " ");
            }

            System.out.print("\nGuess a letter : ");
            char guess = scanner.next().toLowerCase().charAt(0);   //it helps to get only first character no matter what ever string user inputs

            if(word.indexOf(guess) >= 0){            //it will check weather the given guess character is present in our word or not.

                System.out.println("Correct Guess!");

                for (int i = 0 ; i < word.length() ; i++){
                    if(word.charAt(i) == guess){            //to check where this correct guesses character is presents.
                        list.set(i , guess);              //this will replace that underscore with that guessed character
                    }
                }


                //this will check that the list has any underscore left .
                //if there is no left it means user gets correct guess of word.
                if(!list.contains('_')){

                    System.out.println(getHangmanResult(wrongGuesses));
                    System.out.println("You win !");
                    System.out.println("You guessed the correct word: " + word);
                    break;
                }

            }
            else {
                System.out.println("WRONG GUESS!");
                wrongGuesses ++;
            }
        }

        if (wrongGuesses >= 6) {               //if chances gets over.!
            System.out.println(getHangmanResult(wrongGuesses));
            System.out.println("You can't get the correct word!");
            System.out.println("Game over!!");
            System.out.println("You got hanged!!🩻");
            System.out.println("THE WORD IS : " + word);
        }

        scanner.close();
    }

    static String getHangmanResult(int wrongGuesses){

        // we use "\\" because we cannot use single because it is use for new line.

        return switch (wrongGuesses){

            case 0 -> """
                        
                    
                    
                    """;

            case 1 -> """
                       O 
                    
                    
                    """;

            case 2 -> """
                       O 
                       |
                        
                    """;

            case 3 -> """
                       O 
                      /|
                        
                    """;

            case 4 -> """
                       O 
                      /|\\               
                        
                    """;

            case 5 -> """
                       O 
                      /|\\
                      / 
                    """;

            case 6 -> """
                       O 
                      /|\\
                      / \\
                    """;

            default -> "You got hanged!!🩻";
        };
    }
}
