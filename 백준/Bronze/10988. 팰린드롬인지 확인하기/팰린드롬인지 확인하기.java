import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int isPalindrome =0;
        for(int i=0; i<str.length(); i++){

        if(str.charAt(i)!=str.charAt(str.length()-1-i)){
            isPalindrome = 0;
            break;
        } else {
            isPalindrome = 1;
        }
        }
        
        System.out.print(isPalindrome);
    }
}