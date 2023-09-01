
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Solution {
	static int N;
	static Point company;
	static Point home;
	static Point[] customers;
	static boolean[] visited;
	static int min;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customers = new Point[N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				customers[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			min = Integer.MAX_VALUE;
			findShortDist(0, 0, company);
			System.out.printf("#%d %d\n", tc, min);
		}
	}

	public static void findShortDist(int count, int dist, Point last) {
		if(dist>min) return; // 백트래킹, N개를 선택하지 않아도 최소 거리를 초고하면 더이상 탐색하지 않는다.
		if (count == N) {
			int toHome = dist(last, home);
			dist += toHome;
			min = Math.min(min,dist);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				count++;
				visited[i] = true;
				dist += dist(last, customers[i]);
				findShortDist(count, dist, customers[i]);
				count--;
				visited[i] = false;
				dist -= dist(last,customers[i]);
			}
		}
	}

	

	public static int dist(Point a, Point b) {
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}
