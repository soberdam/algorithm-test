import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  불이 붙은 위치에서 BFS를 하여 불이 도착하는 분(최단거리)을 새 배열(fire)에 저장
 *  지훈이의 위치에서 BFS를 하며, 지훈이가 도착하는 시간(최단거리)에 불이 없다면(fire의 값보다 작다면) 이동.
 *  이 이동한 최단거리를 새 배열(escape)에 저장
 */
public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		arr = new int[M];
		backTracking(0);
		System.out.println(sb.toString());
	}
	
	public static void backTracking(int count) {
		if(count==M) {
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[count] = i;
				count++;
				backTracking(count);
				count--;
				arr[count] = 0;
				visited[i] = false;
			}
		}
	}

}