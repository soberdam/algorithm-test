import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	// 동, 남, 서 , 북 시계방향
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int N,K,L;
	static int[][] board;
	static Deque<Point> snake = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 1;
		}
		L = Integer.parseInt(br.readLine());
		Map<Integer, String> dirMap = new HashMap<>();
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			dirMap.put(X, C);
		}
		
		snake.addFirst(new Point(0, 0));
		int second = 0;
		int d = 0;
		Loop: while(true) {
			second++;
//			먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
			int nr = snake.getFirst().x+dr[d];
			int nc = snake.getFirst().y+dc[d];
//			만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
			if(nr<0||nc<0||nr>=N||nc>=N) {
				break;
			}
			for(Point p : snake) {
				if(p.x==nr&&p.y==nc) break Loop;
			}
			snake.addFirst(new Point(nr,nc));
			
//			만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
			if(board[nr][nc]==1) {
				board[nr][nc] = 0;
			} 
			
//			만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
			else {
				snake.removeLast();
			}
//			X초가 끝난 후 C로 방향 회전
			if(dirMap.containsKey(second)) {
				if(dirMap.get(second).equals("L")) {
					d = (d+3)%4;
				} else {
					d = (d+1)%4;
				}
			}
			
		}
		
		System.out.println(second);
		
		
	}


}
//			사과의 위치와 뱀의 이동경로가 주어질 때 이 게임이 몇 초에 끝나는지 계산하라.