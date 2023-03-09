import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int repeatCount;
        String str;
        String strChar;
        
        for(int i=0; i<testCase; i++){
            repeatCount = scanner.nextInt();
            str = scanner.next();
            for(int j=0; j<str.length(); j++){
                strChar = String.valueOf(str.charAt(j));
                System.out.print(strChar.repeat(repeatCount));
            }
            System.out.print("\n");
        }
    }
}
