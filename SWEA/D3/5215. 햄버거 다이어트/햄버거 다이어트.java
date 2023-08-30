
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int L;
	static int[][] arr;
	static boolean[] visited;
	static int ans = Integer.MIN_VALUE;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			arr = new int[N][2];
			visited = new boolean[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			DFS(0, 0, 0);
			
			System.out.printf("#%d %d\n", test_case, ans);
			ans = Integer.MIN_VALUE;
		}
	}

	public static void DFS(int n ,int score, int cal) {
		if(cal<=L) {
			ans = Math.max(ans, score);
		}
		
		for(int i=n; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				score+=arr[i][0];
				cal+=arr[i][1];
				DFS(i, score, cal);
				visited[i] = false;
				score-=arr[i][0];
				cal-=arr[i][1];
			}
		}
	}
}