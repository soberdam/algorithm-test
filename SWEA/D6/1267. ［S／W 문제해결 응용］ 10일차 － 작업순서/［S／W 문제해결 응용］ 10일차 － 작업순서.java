import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


 
public class Solution {
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> result;
	static int[] in_degree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            graph = new ArrayList<>();
            result = new ArrayList<>();
            for(int i=0; i<V+1; i++) {
            	graph.add(new ArrayList<Integer>());
            }
            in_degree = new int[V+1];
            for(int i=0; i<E; i++) {
            	int from = Integer.parseInt(st.nextToken());
            	int to = Integer.parseInt(st.nextToken());
            	if(!graph.get(from).contains(to)) {
            		graph.get(from).add(to);
            		in_degree[to]++;
            	}
            }
            
            topologicalSort();
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<result.size(); i++) {
            	sb.append(result.get(i)).append(' ');
            }
            System.out.printf("#%d %s\n", tc, sb.toString());
 
        }
    	
    }
    
    public static void topologicalSort() {
    	Queue<Integer> queue = new LinkedList<>();
    	
    	for(int i=1; i<in_degree.length; i++) {
    		if(in_degree[i]==0) {
    			queue.add(i);
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		int vertex = queue.poll();
    		result.add(vertex);
    		
    		for(Integer i : graph.get(vertex)) {
    			in_degree[i]--;
    			if(in_degree[i]==0) {
    				queue.add(i);
    			}
    		}
    		
    	}
    	
    }
    
}