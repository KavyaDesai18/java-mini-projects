import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AlarmClock {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;         //it is an object that's why we set it to null not 0.

        String filePath = "src\\On The Flip - The Grey Room _ Density & Time.wav";

        while (alarmTime == null){              // use for continuing that task until user sets the alarm
            try{
                System.out.print("Enter a Alarm Time(HH:mm:ss): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime , formatter);  //it will assign that input time to alarm time using parse method.
                System.out.println("Alarm set for: " + alarmTime);
            }
            catch (DateTimeParseException e) {
                System.out.println("Invalid format!");
                System.out.println("Please Enter a format of (HH:MM:SS) ");
            }
        }

        Clock clock = new Clock(alarmTime , filePath ,scanner);
        Thread alarmThread = new Thread(clock); //it will run the clock class method simultaneously
        alarmThread.start();

    }
}
