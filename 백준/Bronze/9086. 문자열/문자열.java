import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        String str;
        for(int i=0; i<testCount; i++){
            str = scanner.next();
            System.out.print(str.charAt(0));
            System.out.println(str.charAt(str.length()-1));
        }
    }
}