import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 재귀함수의 시작에서 열별로 순회하며 합격기준에 맞는지 확인하고, 맞다면 count를 최솟값으로 업데이트
 * 2. 각 행을 바꿨을 때를 기준으로 재귀를 시작한다.
 * 3. 순열 아닌 조합
 */
public class Solution {
	static int D;
	static int W;
	static int K;
	static int minInject;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			int[][] arr = new int[D][W];
			minInject = Integer.MAX_VALUE;
			visited = new boolean[D];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			injectDrug(arr, 0, 0);
			System.out.printf("#%d %d\n", tc, minInject);

		}

	}

	public static void isPassed(int[][] arr, int count) {
		// 1. 재귀함수의 시작에서 열별로 순회하며 합격기준에 맞는지 확인하고, 맞다면 count를 최솟값으로 업데이트
		boolean update = true;
		Loop1: for (int i = 0; i < W; i++) {
			boolean isPassed = false;
			for (int j = 0; j < D - K + 1; j++) {
				int cnt = 0;
				int temp = arr[j][i];
				for (int k = j; k < D; k++) {
					if (arr[k][i] == temp) {
						cnt++;
						j = k;
						if (cnt >= K) {
							isPassed = true;
							continue Loop1;
						}
					} else {
						break;
					}
				}
			}
			if (!isPassed) {
				update = false;
				break;
			}
		}

		if (update) {
			minInject = Math.min(minInject, count);
		}
	}

	public static void injectDrug(int[][] arr, int count, int r) {

		isPassed(arr, count);

		// 2. 각 행을 A또는 B를 바꿨을 때를 기준으로 재귀를 시작한다.
		for (int i = r; i < D; i++) {
			if (!visited[i] && count + 1 < minInject) {
				visited[i] = true;
				int[] clone = arr[i].clone();
				for(int j=0; j<W; j++) {
					arr[i][j] = 0;
				}
				injectDrug(arr, count + 1, i);
				for(int j=0; j<W; j++) {
					arr[i][j] = 1;
				}
				injectDrug(arr, count + 1, i);
				arr[i] = clone;
				
				visited[i] = false;
			}
		}

	}

	
}
