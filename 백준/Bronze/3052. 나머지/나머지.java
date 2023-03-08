import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int [] remainders = new int [10];
        int [] checkSameNum = new int [10];
        int total = 0;
        for(int i=0; i<10; i++){
            remainders[i] = scanner.nextInt()%42;
            checkSameNum[i] = 0;
        }
        
        for(int i=0; i<10; i++){
            for(int j=i+1; j<10; j++){
                if(remainders[i]==remainders[j]){
                    checkSameNum[i] =1;
                    break;
                }
            }
            
        }
        
        for(int i=0; i<10; i++){
            if(checkSameNum[i]==0){
                total++;
            }
        }
        System.out.print(total);
    }
}