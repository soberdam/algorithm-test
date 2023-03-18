import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [][] nm = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               nm[i][j] = scanner.nextInt();
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               nm[i][j] += scanner.nextInt();
               System.out.print(nm[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}