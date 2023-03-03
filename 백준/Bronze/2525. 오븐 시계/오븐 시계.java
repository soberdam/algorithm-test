import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int cookingTime = scanner.nextInt();
        
        int plusHour = (b+cookingTime)/60;
        int minute = (b + cookingTime)%60;
        int hour = a+plusHour;
        if(hour<24) {
            System.out.print(hour + " " + minute);
        } else {
            System.out.print((hour%24) + " " + minute);
        }
        
    }
}