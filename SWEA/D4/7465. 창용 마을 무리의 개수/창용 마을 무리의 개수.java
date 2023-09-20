import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution {
	static int N;
	static int M;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			for(int i=1; i<=N; i++) {
				parent[i] = i;
			}
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				Union(x,y);
			}
			
			Set<Integer> set = new HashSet<>();
			for(int i=1; i<=N; i++) {
				set.add(Find(i));
			}
			
			System.out.printf("#%d %d\n", tc, set.size());
			
		}

	}
	
	public static int Find(int x) {
		if(x==parent[x]) return x;
		
		return Find(parent[x]);
	}
	
	public static void Union(int x, int y) {
		x = Find(x);
		y = Find(y);
		
		if(x==y) return;
		
		else if(x<y) {
			parent[y] = x;
		} 
		else {
			parent[x] = y;
		}
	}
	

}
