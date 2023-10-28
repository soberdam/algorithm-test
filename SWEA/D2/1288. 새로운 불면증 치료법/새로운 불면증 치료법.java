import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Island {
	int x;
	int y;
	int parent;
	
	Island(int x, int y, int parent) {
		this.x=x;
		this.y=y;
		this.parent=parent;
	}
}

class Edge implements Comparable {
	int start;
	int end;
	long value;
	
	Edge(int start, int end) {
		this.start = start;
		this.end = end;
		this.value = (long) ((long)Math.pow(Solution.islands[start].x - Solution.islands[end].x,2) + Math.pow(Solution.islands[start].y - Solution.islands[end].y,2)); 
	}

	@Override
	public int compareTo(Object o) {
		Edge e = (Edge)o;
		if(this.value > e.value) return 1;
		if(this.value == e.value) return 0;
		return -1;
	}
}

public class Solution {
	static int N;
	static double E;
	static Island [] islands;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			HashSet<Integer> set = new HashSet<>();
			int k = 0;
			while(set.size()!=10) {
				k++;
				int temp = N*k;
				String str = String.valueOf(temp);
				for(int i=0; i<str.length(); i++) {
					char c = str.charAt(i);
					set.add(c-'0');
				}				
				
			}			
			System.out.printf("#%d %s\n", tc, k*N);
			
		}

	}

}