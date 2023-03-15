import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String [] croatianAlpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        for(int i=0; i<croatianAlpha.length; i++){
            str = str.replace(croatianAlpha[i],"a");
        }
        
        System.out.print(str.length());
    }
    
}