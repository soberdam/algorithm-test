import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		// 지도 저장
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문하지 않은 1을 만나면 큐에 담고 visited[r][c]를 true로 하고 너비우선 탐색(상하좌우가 연결)한다.
				if (arr[i][j] == 1 && visited[i][j]==false) {
					int count = 1;
					visited[i][j] = true;
					queue.offer(new int[] { i, j });
					while (!queue.isEmpty()) {
						
						int[] addr = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = addr[0] +dr[d];
							int nc = addr[1] +dc[d];
							if(nr>=0 && nc >=0 && nr<N && nc < N && arr[nr][nc]==1 && visited[nr][nc]==false) {
								visited[nr][nc] = true;
								count++;
								queue.offer(new int[] { nr, nc });
							}
						}
					}
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int n : list) {
			System.out.println(n);
		}

	}

}