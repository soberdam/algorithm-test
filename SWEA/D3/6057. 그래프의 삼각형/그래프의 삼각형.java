import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 1. DFS로 간선을 3번 이동한 경우를 백트래킹한다.
 * 2. (depth가 0일 때)첫 시작 정점의 방문을 true로 하고, true인 정점은 다시 방문하지 않는다. 
 * 3. 2번 이동했을 때 돌아올 수 있는지 확인하고, 가능하면 삼각형의 개수를 count++한다.
 */

public class Solution {
	static int count;
	static int N;
	static int M;
	static boolean[] from;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			from = new boolean[N + 1];
			graph = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph.get(start).add(end);
				graph.get(end).add(start);
			}
			for(int i=1; i<=N; i++) {
				backTracking(0, i, i);
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}

	}

	public static void backTracking(int depth, int start, int last) {
		if (depth == 2) {
			for(int i=0; i<graph.get(last).size(); i++) {
				if(graph.get(last).get(i)==start) {
					count++;
				}
			}
			return;
		}

		for(int i=0; i<graph.get(last).size(); i++) {
			int arrival = graph.get(last).get(i);
			if(arrival>last) {
				backTracking(depth+1, start, arrival);
			}
		}
		
	}

}
