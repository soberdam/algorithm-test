import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int basketCount = scanner.nextInt();
        int rotateCount = scanner.nextInt();
        int [] baskets = new int [basketCount+1];
        int [] tempArr = new int [baskets.length];
        int begin;
        int end;
        int mid;
        for(int i=1; i<baskets.length; i++){
            baskets[i] = i;
        }
        
        for(int i=0; i<rotateCount; i++){
            begin = scanner.nextInt();
            end = scanner.nextInt();
            mid = scanner.nextInt();
            for(int j=0; j<baskets.length; j++) {
            	tempArr[j] = baskets[j];
            }
            for(int j = begin; j<=end; j++){
                if(mid<=end) {
                    baskets[j] = tempArr[mid];
                    mid++;
                } else {
                    baskets[j] = tempArr[begin];
                    begin++;
                }
                
            }
            
        }
        
        for(int i=1; i<baskets.length; i++){
            System.out.print(baskets[i] + " ");
        }
        
    }
}