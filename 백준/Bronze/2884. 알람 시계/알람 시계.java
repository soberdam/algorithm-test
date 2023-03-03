import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        
        if (minute>=45) {
            System.out.print(hour + " " + (minute-45));
        } else {
            if (hour != 0) {
                System.out.print(hour-1 + " " + (60-Math.abs(minute-45)));
            } else {
                System.out.print(23 + " " + (60-Math.abs(minute-45)));
            }
        }
    }
}