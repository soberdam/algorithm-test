import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int num = scanner.nextInt();
        
        System.out.print(str.charAt(num-1));
    }
}    