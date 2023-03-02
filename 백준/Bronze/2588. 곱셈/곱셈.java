import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int numOf100 = b/100;
        int numOf10 = (b - (numOf100*100))/10;
        int numOf1 = b - (numOf100*100) - (numOf10*10);
        System.out.println(a*numOf1);
        System.out.println(a*numOf10);
        System.out.println(a*numOf100);
        System.out.println(a*b);
    }
}