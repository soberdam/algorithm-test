import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int starNum = sc.nextInt();
        String star = "*";
        for (int i=1; i<=starNum; i++) {
            System.out.println(star.repeat(i));
        }
    }
}