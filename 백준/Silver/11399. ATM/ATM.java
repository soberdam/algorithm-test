import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[t];
        int answer = 0;
        for(int i=0; i<t; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0; i<t; i++) {
            answer+=arr[i]*(t-i);
        }
        System.out.print(answer);
    }
}