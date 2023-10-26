/*
 * 
 1. 늑대는 가중치를 *0.5, *2를 계속 곱하여 더하기 때문에 처음에 여우와 늑대의 거리를 받을때 *2하여 짝수로 받는다.  
 2. 달빛여우는 노드 1에서 시작하는 정석 다익스트라
 3. 달빛늑대는 홀수번째에 0.5의 가중치, 짝수번째에 *2의 가중치로 이동한다.
 4. 그렇다면  짝수번째에 가중치가 큰 노드를 방문할 때에는 최단거리가 아닐 수 있다.
 4-1. 예시 1)1 3 500, 1 2 1
 4-2. 예시 2) 
		1 2 1 
		2 3 2
		3 1 3
		1 4 4
		4 5 500 
 5. 홀수번째 방문할때(홀수개의 사이클)와 짝수번째 방문할 때 거리를 따로 저장하자.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[][] map;
	static boolean[][] isDirect;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		isDirect = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==map[i][k]+map[j][k]&& i!=k && j!=k) {
						isDirect[i][j] = true;
					}
					if(map[i][j]>map[i][k]+map[j][k]&& i!=k && j!=k) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!isDirect[i][j]) {
					result+=map[i][j];
				}
			}
		}
		answer = result == 0 ? -1 : result/2;
		System.out.println(answer);

	}
	


}