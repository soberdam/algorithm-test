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
	static int[] printArr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		visited = new boolean[N];
		printArr = new int[M];
		for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		backTracking(0);
		System.out.println(sb.toString());
	}
	public static void backTracking(int count) {
		if(count==M) {
			for(int i=0; i<M; i++) {
				sb.append(String.valueOf(printArr[i])).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				printArr[count] = arr[i];
				backTracking(count+1);
				visited[i] = false;
			}
		}
	}
	
	
}
