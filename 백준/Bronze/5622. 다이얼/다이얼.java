import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        
        int minTime = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) <= 'C'){
                minTime+=3;
            } else if(str.charAt(i) <= 'F') {
                minTime+=4;
            } else if(str.charAt(i) <= 'I') {
                minTime+=5;
            } else if(str.charAt(i) <= 'L') {
                minTime+=6;
            } else if(str.charAt(i) <= 'O') {
                minTime+=7;
            } else if(str.charAt(i) <= 'S') {
                minTime+=8;
            } else if(str.charAt(i) <= 'V') {
                minTime+=9;
            } else if(str.charAt(i) <= 'Z') {
                minTime+=10;
            }
        }
        System.out.print(minTime);        
    }
}