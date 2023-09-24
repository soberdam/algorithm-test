import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int[] printArr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		printArr = new int[M];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		bfs(0);
		System.out.println(sb.toString());
	}
	
	public static void bfs(int depth) {
		if(depth==M) {
			for(int i=0; i<M; i++) {
				sb.append(printArr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		int before = -1;
		for(int i=0; i<N; i++) {
			int now = arr[i];
			if(now != before) {
				before = now;
				printArr[depth] = arr[i];
				bfs(depth+1);
			}
		}
	}

}