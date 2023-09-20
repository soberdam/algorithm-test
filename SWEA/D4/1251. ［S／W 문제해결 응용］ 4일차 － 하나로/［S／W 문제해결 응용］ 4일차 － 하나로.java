import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island {
	int x;
	int y;
	int parent;

	Island(int x, int y, int parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
	}
}

class Edge implements Comparable {
	int start;
	int end;
	double value;

	Edge(int start, int end) {
		this.start = start;
		this.end = end;
		this.value = Math.pow((Solution.islands[start].x - Solution.islands[end].x),2)
				+  Math.pow((Solution.islands[start].y - Solution.islands[end].y),2);
	}

	@Override
	public int compareTo(Object o) {
		Edge e = (Edge) o;
		if (this.value > e.value)
			return 1;
		if (this.value == e.value)
			return 0;
		return -1;
	}
}

public class Solution {
	static int N;
	static double E;
	static Island[] islands;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			islands = new Island[N + 1];
			PriorityQueue<Edge> edges = new PriorityQueue<>();

			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int x = Integer.parseInt(stX.nextToken());
				int y = Integer.parseInt(stY.nextToken());
				islands[i] = new Island(x, y, i);

			}

			E = Double.parseDouble(br.readLine());

			for (int i = 1; i <= N - 1; i++) {
				for (int j = i + 1; j <= N; j++) {
					edges.add(new Edge(i, j));
				}
			}

			double result = 0;
			while (!edges.isEmpty()) {
				Edge edge = edges.poll();
				int start = edge.start;
				int end = edge.end;
				double value = edge.value;
				if (!isUnion(start, end)) {
					Union(start, end);
					result += value * E;
				}
			}
			long answer = Math.round(result);
			System.out.printf("#%d %d\n", tc, answer);

		}

	}

	public static int Find(int x) {
		if (x == islands[x].parent)
			return x;

		return islands[x].parent = Find(islands[x].parent);
	}

	public static void Union(int x, int y) {
		x = Find(x);
		y = Find(y);

		if (x == y)
			return;

		else if (x < y) {
			islands[y].parent = islands[x].parent;
		} else {
			islands[x].parent = islands[y].parent;
		}
	}

	public static boolean isUnion(int x, int y) {
		return Find(x) == Find(y);

	}

}