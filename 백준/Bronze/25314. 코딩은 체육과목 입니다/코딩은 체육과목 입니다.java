import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            int inputNum = scanner.nextInt();
            int longNum = inputNum/4;
            String longStr = "long ";
        
        System.out.print(longStr.repeat(longNum)+"int");
    }
}