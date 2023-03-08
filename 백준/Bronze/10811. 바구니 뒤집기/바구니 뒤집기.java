import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int basketNum = scanner.nextInt();
        int lineNum = scanner.nextInt();
        int [] baskets = new int [basketNum+1];
        int [] reverseBaskets = new int [basketNum];
        int basketStart;
        int basketEnd;
        for(int i=1;i<=basketNum;i++){
            baskets[i] = i;
        }
        
        for(int i=0;i<lineNum;i++){
            basketStart = scanner.nextInt();
            basketEnd = scanner.nextInt();
            int k = 0;
            for(int j = basketEnd; j>= basketStart; j--){
                reverseBaskets[k] = baskets[j];
                k++;
            }
            
            for(int h=0; h<k; h++){
                baskets[basketStart+h] = reverseBaskets[h];                   
            }
        }
        
        
        for(int i=1;i<=basketNum;i++){
            System.out.print(baskets[i]+" ");
        }
        
    }
}
