import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
 

 
public class Solution {
	static class Edge implements Comparable {
	    int start;
	    int end;
	    double value;
	 
	    Edge(int start, int end) {
	        this.start = start;
	        this.end = end;
	        this.value = E*(Math.pow(islands[start].x-islands[end].x, 2) + Math.pow(islands[start].y-islands[end].y, 2));
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
	
    static int N;
    static double E;
    static Island[] islands;
    static ArrayList<ArrayList<Edge>> edges;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine());
            islands = new Island[N + 1];
            edges = new ArrayList<>();
 
            StringTokenizer stX = new StringTokenizer(br.readLine());
            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int x = Integer.parseInt(stX.nextToken());
                int y = Integer.parseInt(stY.nextToken());
                islands[i] = new Island(x, y, i);
 
            }
            
            for(int i=0; i<N+1; i++) {
            	edges.add(new ArrayList<Edge>());
            }
 
            E = Double.parseDouble(br.readLine());
 
            for (int i = 1; i <= N - 1; i++) {
                for (int j = i + 1; j <= N; j++) {
                    edges.get(i).add(new Edge(i, j));
                    edges.get(j).add(new Edge(j, i));
                }
            }
            
            long answer = prim(1);
            System.out.printf("#%d %d\n", tc, answer);
 
        }
 
    }
    
    public static long prim(int start) {
    	boolean[] visited = new boolean[N+1];
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	pq.offer(new Edge(start, start));
    	
    	double total = 0;
    	while(!pq.isEmpty()) {
    		Edge edge = pq.poll();
    		int end = edge.end;
    		double value = edge.value;
    		
    		if(visited[end]) continue;
    		
    		visited[end] = true;
    		total += value;
    		
    		for(int i=0; i<edges.get(end).size(); i++) {
    			Edge e = edges.get(end).get(i);
    			if(!visited[e.end]) {
    				pq.add(e);
    			}
    		}
    		
    	}
    	
    	return Math.round(total);
    }

 
}