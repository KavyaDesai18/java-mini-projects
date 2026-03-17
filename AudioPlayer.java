import javax.sound.SoundClip;
import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedMap;

public class AudioPlayer {

    public static void main(String[] args){

        String filePath = "src\\On The Flip - The Grey Room _ Density & Time.wav";
        File file = new File(filePath);        //file object is created to store the located WAV file and access it in program

        //which is written in try block is get closed object whenever the program is get completed.
        //we can add multiple things in same try block which is separated by ";"

        try(Scanner scanner = new Scanner(System.in) ;
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file) ){   // this is for opening that located file in player

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);          //for open that player and give access to control that file

            String response = "";

            while (!response.equals("Q")){
                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");

                System.out.print("Enter your choice: ");
                response = scanner.nextLine().toUpperCase();

                switch (response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);  //This is use for the again restart the music from 0 second.
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid choice!");
                }
            }
        }

        catch (UnsupportedAudioFileException e){               //for handling the wrong inout file like audio this player doesn't support audio file.
            System.out.println("Audio file can't supported!");
        }

        catch (FileNotFoundException e){
            System.out.println("File cannot located!!");
        }

        catch (IOException e){
            System.out.println("Something Went WRONG!!");
        }

        catch (LineUnavailableException e){
            System.out.println("Unable to access audio resource!!");
        }

        finally {
            System.out.println("Bye!!!");
        }
    }
}
