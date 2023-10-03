import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * dp[i] = dp[i] + dp[i-arr[j]]
 */
public class Main {
	static int n;
	static int k;
	static int[] dp;
	static int[] coins;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[k + 1];
		coins = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			
		}
		
		dp[0] = 1;
		
		for(int i=1; i<=n; i++) {
			for(int j=coins[i]; j<=k; j++) {
				dp[j] += dp[j-coins[i]];
			}
			
		}
		System.out.println(dp[k]);
	}// main

	

}