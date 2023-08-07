import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        String word = sc.next();
        for(int i=0; i<word.length(); i++) {
            arr[word.charAt(i)-'a']++;           
        }
        
        for(int cnt : arr) {
            System.out.print(cnt + " ");
        }
    }
}