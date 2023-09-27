import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
 * 1. dp 테이블  : K를 만드는데 필요한 동전의 최소한의 개수
 * 2. 점화식 : if i > arr[j] dp[i] = min(dp[i],dp[i-arr[j]]+1)
 * 3. 초기화 : dp[1~K] = Integer.MAX_VALUE-1, dp[arr[j]] = 1
 */

public class Main {
	static int N, K;
	static int[] coins;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		dp = new int[K + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			if (coins[i] <= K)
				dp[coins[i]] = 1;
		}
		
		

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j < N; j++) {
				if (i > coins[j])
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
			}
		}

		if (dp[K] == Integer.MAX_VALUE-1) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}

	}

}
