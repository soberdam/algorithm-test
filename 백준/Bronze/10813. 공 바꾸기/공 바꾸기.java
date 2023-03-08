import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int [] baskets = new int[N];
        int firstBasket = 0;
        int secondBasket = 0;
        int firstBall = 0;
        int secondBall = 0;
        
        for(int i=0;i<N;i++){
            baskets[i] = i+1;
        }        
        for(int i=0;i<M;i++){
            firstBasket = scanner.nextInt();
            secondBasket = scanner.nextInt();
            firstBall = baskets[firstBasket-1];
            secondBall = baskets[secondBasket-1];
            
            baskets[firstBasket-1] = secondBall;
            baskets[secondBasket-1] = firstBall;
        }
        
        for(int i=0;i<N;i++){
            System.out.print(baskets[i]+" ");
        }
        
    }
}