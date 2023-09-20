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
			StringBuilder sb = new StringBuilder();
			
			parent = new int[N+1];
			for(int i=1; i<=N; i++) {
				parent[i] = i;
			}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				switch(order) {
					case 0:
						Union(x,y);
						break;
					case 1:
						if(isUnion(x,y)) {
							sb.append(1);
						} else {
							sb.append(0);
						}
						break;
				}
			}
			
			
			System.out.printf("#%d %s\n", tc, sb.toString());
			
		}

	}
	
	public static int Find(int x) {
		if(x==parent[x]) return x;
		
		return parent[x] = Find(parent[x]);
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
	
	public static boolean isUnion(int x, int y) {
		if(Find(x)==Find(y)) return true;
		
		return false;
	}

}
