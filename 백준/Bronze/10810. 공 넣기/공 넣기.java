import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [] baskets = new int [N];
        int M = scanner.nextInt();
        int firstBasket = 0;
        int secondBasket = 0;
        int ballNum = 0;
        for(int i=0; i<N; i++) {
            baskets[i] = 0;
        }
        
        for(int i=0; i<M; i++) {
                firstBasket = scanner.nextInt();
                secondBasket = scanner.nextInt();
                ballNum = scanner.nextInt();
            for(int j=firstBasket-1; j<=secondBasket-1; j++){
                baskets[j] = ballNum;
            }
        }
        

        

        for(int i=0; i<N; i++) {
            System.out.print(baskets[i]+" ");
        }
    }
}