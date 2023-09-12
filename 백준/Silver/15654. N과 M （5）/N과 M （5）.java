import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *
 */



public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		backTracking(0, new StringBuilder());
		System.out.println(sb.toString());
	}
	public static void backTracking(int count, StringBuilder temp) {
		if(count==M) {
			System.out.println(temp.toString());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				String s = temp.toString();
				temp.append(String.valueOf(arr[i])).append(' ');
				backTracking(count+1, new StringBuilder(temp.toString()));
				temp.setLength(0);
				temp.append(s);
				visited[i] = false;
			}
		}
	}
	
	
}
