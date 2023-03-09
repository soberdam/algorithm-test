import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        boolean matched;
        for(char i='a'; i<='z'; i++) {
            matched = false;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == i) {
                    matched = true;
                    System.out.print(j+" ");
                    break;
                } 
            }
            if (matched == false) {
                System.out.print(-1+" ");
            } 
        }
        
    }
}