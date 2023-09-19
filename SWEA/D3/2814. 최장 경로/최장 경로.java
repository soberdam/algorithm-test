import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 1. DFS로 갈 수 있는 모든 경로를 탐색하고, 길이가 최장인 것을 업데이트해가며 찾는다.
 */

public class Solution {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			graph = new ArrayList<>();
			visited = new boolean[N+1];
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph.get(start).add(end);
				graph.get(end).add(start);
			}
			
			for(int i=1; i<=N; i++) {
				visited[i]=true;
				DFS(1,i);
				visited[i] = false;
			}
			System.out.printf("#%d %d\n", tc, max);
			
		}

	}
	
	public static void DFS(int count, int start) {
		max = Math.max(count, max);
		
		ArrayList<Integer> arrivals = graph.get(start);
		for(int i=0; i<arrivals.size(); i++) {
			int arrival = arrivals.get(i);
			if(!visited[arrival]) {
				visited[arrival] = true;
				DFS(count+1, arrival);
				visited[arrival] = false;
			}
		}		
	}				

}
