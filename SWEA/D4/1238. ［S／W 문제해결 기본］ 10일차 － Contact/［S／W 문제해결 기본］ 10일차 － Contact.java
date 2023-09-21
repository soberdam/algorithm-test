import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


 
public class Solution {
	static  ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            graph = new ArrayList<>();
            
            for(int i=0; i<101; i++) {
            	graph.add(new ArrayList<Integer>());
            }
            
            for(int i=0; i<len/2; i++) {
            	int from = Integer.parseInt(st.nextToken());
            	int to = Integer.parseInt(st.nextToken());
            	if(!graph.get(from).contains(to)) {
            		graph.get(from).add(to);
            	}
            }
            int answer = bfs(start, len);
            System.out.printf("#%d %d\n", tc, answer);
 
        }
    	
    }
    
    public static int bfs(int start, int len) {
    	int[] distance = new int[101];
    	Arrays.fill(distance, -1);
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(start);
    	distance[start] = 0;
    	
    	while(!queue.isEmpty()) {
    		int node = queue.poll();
    		for(int i=0; i<graph.get(node).size(); i++) {
    			int next = graph.get(node).get(i);
    			if(distance[next]==-1) {
    				distance[next] = distance[node] + 1;
    				queue.add(next);
    			}
    		}
    	}
    	int max = Integer.MIN_VALUE;
    	int idx = 1;
    	for(int i=1; i<=100; i++) {
    		if(distance[i]>=max) {
    			max = distance[i];
    			idx = i;
    		}
    	}
    	
    	return idx;
    }
    
}