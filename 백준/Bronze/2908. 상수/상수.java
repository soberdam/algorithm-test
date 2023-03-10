import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numA = scanner.nextInt();
        int numB = scanner.nextInt();
        
        String strA = String.valueOf(numA);
        String strB = String.valueOf(numB);
        
        String reverseStrA = "";
        String reverseStrB = "";
        for(int i=2; i>=0; i--){
            reverseStrA += strA.charAt(i);
            reverseStrB += strB.charAt(i);
        }
        int reverseA = Integer.parseInt(reverseStrA);
        int reverseB = Integer.parseInt(reverseStrB);
        System.out.print(Math.max(reverseA, reverseB));
        
        
    }
}
