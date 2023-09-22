import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * dp테이블은 item 순서 * 가방용량 조합에 가장 최대 넣을 수 있는 무게
 * dp[i][j] = dp[i-1][j];
 * if(w[i]<=j) dp[i][j] = max(dp[i][j], dp[i-1][j-w[i]] + v[i])  
 */
public class Main {
 
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[N+1][K+1];
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for(int i=1; i<=N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int W = Integer.parseInt(st.nextToken());
        	int V = Integer.parseInt(st.nextToken());
        	w[i] = W;
        	v[i] = V;
        }
        
        for(int i=1; i<=N; i++) {
        	for(int j=1; j<=K; j++) {
        		dp[i][j] = dp[i-1][j];
        		if(w[i]<=j) {
        			dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
        		}
        	}
        }
        
        System.out.println(dp[N][K]);
        
    }
 
 
}
