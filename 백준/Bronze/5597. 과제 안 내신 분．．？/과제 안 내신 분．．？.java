import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int [] submitStudent = new int[29];
        int [] result = new int[31];
        for(int i=1; i<29; i++){
            submitStudent[i] = scanner.nextInt();
        }
        for(int i=1; i<31; i++){
            result[i] = 0;
        }
        
  
         for(int i=1; i<29; i++){
             for(int j=1; j<31; j++){
                 if(submitStudent[i] == j) {
                     result[j] = 1;
                     break;
                 } 
             }
         }
         
        for(int i=1; i<31; i++){
            if(result[i] == 0) {
                System.out.print(i+" ");
            }

        }
        
    }
}