//각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력한다. 
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        int a = 0;
        int b = 0;
        int i = 1;
        while(i<=testNum) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("Case #" + i + ": " + a + " + " + b + " = " + (a+b) );
            i++;
        }
        
    }
}