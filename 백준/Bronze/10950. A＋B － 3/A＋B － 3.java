import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        int a = 0;
        int b = 0;
        
        for(int i=1; i<=testNum; i++){
            a = scanner.nextInt();
            b = scanner.nextInt();
            System.out.println(a+b);
        }
        
    }
}