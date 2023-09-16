import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
	static boolean[] number = new boolean[10001];
	static Set<String> set = new HashSet<String>(); 
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
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		backTracking(0);
		System.out.println(sb.toString());
	}

	public static void backTracking(int count) {
		StringBuilder temp = new StringBuilder();
		if (count == M) {
			for (int i = 0; i < M; i++) {
				temp.append(String.valueOf(printArr[i])).append(' ');
				
			}
			if(set.contains(temp.toString())) {
				return;
			} else {
				set.add(temp.toString());
				temp.append('\n');
				sb.append(temp.toString());
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				printArr[count] = arr[i];
				backTracking(count + 1);
				visited[i] = false;
			}

		}
	}

}
