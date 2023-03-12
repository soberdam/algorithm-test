import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int spaceCount = n-1;
        int starCount = 1;
        for(int i=0; i<2*n-1; i++){
            for(int j=0; j<spaceCount; j++){
                System.out.print(" ");
            }
            for(int j=0; j<starCount; j++){
                System.out.print("*");
            }
            
            System.out.println();
            if(i <(2*n-1)/2) {
                starCount += 2;
                spaceCount--;
            } else {
                spaceCount++;
                starCount-= 2;
            }
            
        }
    }
}