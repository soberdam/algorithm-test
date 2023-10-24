import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable {
	int index;
	int cost;
	
	Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Object o) {
		return cost - ((Node)o).cost;
	}
	
}
public class Main {
	static int N, E;
	static boolean[] visited;
	static int[] dist;
	static int answer;
	static List<List<Node>> graph = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		
		answer = 0;
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);
		
		if(res1>=10000000&&res2>=10000000) {
			answer = -1;
		} else {
			answer = Math.min(res1, res2);
		}
		
		System.out.println(answer);
	}
	
	public static int dijkstra(int start, int end) {
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, 10000000);
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.index]) continue;
			visited[cur.index] = true;
			
			for(Node next : graph.get(cur.index)) {
				if(!visited[next.index]&&dist[cur.index]+next.cost<dist[next.index]) {
					dist[next.index] = dist[cur.index]+next.cost;
					pq.add(new Node(next.index, dist[next.index]));
				}
			}
		}
		
		return dist[end];
	}
}