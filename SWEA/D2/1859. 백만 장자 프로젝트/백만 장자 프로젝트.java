import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			long sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int [N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = Integer.MIN_VALUE;
			for(int i=N-1; i>=0; i--) {
				max = Math.max(arr[i], max);
				sum += max - arr[i];
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}
	}
}