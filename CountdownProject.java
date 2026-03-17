import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownProject {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter # of second to countdown from: ");
        int response = scanner.nextInt();
        scanner.nextLine();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            int count = response;
            @Override
            public void run() {
                System.out.println(count);
                count--;
                if(count < 0){
                    System.out.println("Happy Birthday To You!");
                    timer.cancel();
                }
            }
        };

        timer.schedule(task , 0,1000 );
    }
}
