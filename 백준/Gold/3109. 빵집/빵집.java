
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point {
	int x;
	int y;
	boolean broken;
	
	Point(int x, int y, boolean broken) {
		this.x=x;
		this.y=y;
		this.broken=broken;
	}
}
public class Main {
	static int[] dr = {-1, 0, 1};
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			dfsUp(i,0);
		}

		System.out.println(answer);

	}
	
	public static boolean dfsUp(int row, int col) {
		if(col==C-1) {
			answer++;
			// 연결되었음을 return
			return true;
		}
		
		for(int d=0; d<3; d++) {
			int nr = row+dr[d];
			int nc = col+1;
			if(nr<0||nc<0||nr>=R||nc>=C) continue;
			if(!visited[nr][nc]&&map[nr][nc]!='x') {
				visited[nr][nc]=true;
				boolean isConnected = dfsUp(nr, nc);
				if(!isConnected) {
					// 연결되지 않았다면 다른 방향 탐색
					continue;
				}
				// 연결 했다면 해당 시작점에서의 경로는 더 확인 할 필요 없으므로 그대로 return
				return isConnected;
			}
		}
		// 3방향 모두 탐색했다면 
		visited[row][col] = true;
		return false;
	}
	


}