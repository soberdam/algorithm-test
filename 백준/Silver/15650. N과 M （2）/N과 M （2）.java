import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 1. 재귀 함수의 시작마다 반복문으로 사각형을 확인한다.
 * 2. 배열 내부에서 모두 1이거나 모두 0인경우 blue 혹은 white를 증가시키고 return한다.
 * 3. 아니라면 지금 사각형을 4등분하여 4개의 재귀를 시작한다.
 * 4. 함수의 인자로는 행의 시작, 열의 시작, 한 변의 길이를 지정한다.
 */



public class Main {
	
	static boolean [] visited;
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		backTracking(1,0);
		
		
	}
	
	public static void backTracking(int idx, int count) {
		if(count==M) {
			for(int i=1; i<=N; i++) {
				if(visited[i]) {
					sb.append(String.valueOf(i)).append(' ');
				}
			}
			System.out.println(sb.toString());
			sb.setLength(0);
			return;
		}
		for(int i=idx; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backTracking(i, count+1);
				visited[i] = false;
			}
		}
	}
}
