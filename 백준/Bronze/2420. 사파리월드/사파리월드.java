import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long answer = 0;
        if (a<b) 
            answer = Math.abs(a-b);
        else 
            answer = a-b;
        System.out.println(answer);
    }
    
}