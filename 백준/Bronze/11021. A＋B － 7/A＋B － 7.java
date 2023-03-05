/*입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.*/
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = sc.nextInt();
        int a = 0;
        int b = 0;
            
        for(int i=1; i<=testNum; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println("Case #"+ i + ": " + (a+b));
                
        }
    }
}
