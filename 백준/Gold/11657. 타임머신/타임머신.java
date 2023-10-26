import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
	int v;
	int w;
	int cost;
	
	public Edge(int v, int w, int cost) {
		this.v=v;
		this.w=w;
		this.cost = cost;
	}
	
}

public class Main {
	static int N, M;
	static List<Edge> edges = new ArrayList<>();
	static Long[] dist;
	static int answer;
	final static Long INF = Long.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new Long[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(v, w, cost));
			
		}
		if(bellmanFord(1)) {
			System.out.println(-1);
		} else {
			for(int i=2; i<=N; i++) {
				if(dist[i]==INF) {
					System.out.println(-1);
				} else {
					System.out.println(dist[i]);
				}
			}
		}
		
		
	}
	
	public static boolean bellmanFord(int start) {
		Arrays.fill(dist, INF);
		dist[start] = 0L;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Edge e = edges.get(j);
				
				if(dist[e.v]!=INF&&dist[e.v]+e.cost<dist[e.w]) {
					if(i==N-1) {
						return true;
					}
					dist[e.w] = dist[e.v] + e.cost;
				}
			}
		}
		return false;
	}
	


}