import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int maxArrNum = 0;
        int [] numList = new int [9];
        for(int i=0; i<9; i++) {
            numList[i] = scanner.nextInt();
            if(i==0) {
                max = numList[i];
                maxArrNum = i;
            } else {
                if (numList[i] > max) {
                    max = numList[i];
                    maxArrNum = i;
                }
            }
        }
        System.out.println(max);
        System.out.println(maxArrNum+1);
        
    }
}