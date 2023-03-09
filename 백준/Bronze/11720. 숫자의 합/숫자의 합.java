import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int total = 0;
        for(int i=0; i<count; i++){
            total += Character.getNumericValue(str.charAt(i));
        }
        System.out.print(total);
    }
}