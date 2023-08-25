import java.util.Scanner;
 
class Solution {
     
 
    public static void main(String args[]) throws Exception {
 
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
             
            for(int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++) {
                    String s = String.valueOf(arr[i]*arr[j]);
                    boolean isAscending = true;
                    for(int k=1; k<s.length(); k++) {
                        if((int)(s.charAt(k)-'0') < (int)(s.charAt(k-1)-'0')) {
                            isAscending = false;
                        }
                    }
                    if(isAscending) {
                        max = Math.max(max, arr[i]*arr[j]);
                    }
                }
            }
             
            if(max == Integer.MIN_VALUE) {
                max = -1;
            }
             
 
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
 
}