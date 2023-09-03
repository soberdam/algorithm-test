import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

 
public class Solution {
	static int N;
	static int B;
	static int min;
	static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=1; tc<=T; tc++) {
        	min = Integer.MAX_VALUE;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken()); // 점원의 수
        	B = Integer.parseInt(st.nextToken()); // 선반의 높이
        	st = new StringTokenizer(br.readLine());
        	arr = new int[N];
        	for(int i=0; i<N; i++) {
        		arr[i]=Integer.parseInt(st.nextToken());
        	}
        	backTracking(0, 0);
        	System.out.printf("#%d %d\n", tc, min-B);
        }
    }
    
    public static void backTracking(int r, int sum) {
    	if(sum>=B) {
    		min = Math.min(min, sum);
    		return;
    	}
    	
    	for(int i=r; i<arr.length; i++) {
    		if(arr[i]!=0) {
    			int temp = arr[i];
    			sum+= temp;
    			arr[i] = 0;
    			backTracking(i, sum);
    			sum-=temp;
    			arr[i] = temp;
    		}
    	}
    }
 
    
}