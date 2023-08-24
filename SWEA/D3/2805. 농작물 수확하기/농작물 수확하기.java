import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static boolean[][] visited;
	static int sum;
	static int N;
	static int count = 0;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			sum = 0;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			int [][] visited = new int[N][N];
			
			int idx = 0;
			for (int i = 0; i < N/2; i++) {
				for (int j = N / 2; j >= N/2-idx; j--) {
					sum+=arr[i][j];
					visited[i][j] += 1;
				}
				for (int j = N / 2; j <= N/2+idx; j++) {
					sum+=arr[i][j];
					visited[i][j] += 1;
				}
				sum-=arr[i][N/2];
				visited[i][N/2] -= 1;
				idx++;
			}
			
			idx = N/2;
			for (int i = N/2; i < N; i++) {
				for (int j = N / 2; j >= N/2-idx; j--) {
					sum+=arr[i][j];
					visited[i][j] += 1;
				}
				for (int j = N / 2; j <= N/2+idx; j++) {
					sum+=arr[i][j];
					visited[i][j] += 1;
				}
				sum-=arr[i][N/2];
				visited[i][N/2] -= 1;
				idx--;
			}

//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) {
//					System.out.print(visited[i][j]);
//				}
//				System.out.println();
//			}

			System.out.printf("#%d %d\n", test_case, sum);
		}
	}

}