
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
	static int[][] visited;
	static int answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			dfsUp(i,0);
		}
//		int temp = answer;
//		
//		visited = new boolean[R][C];
//		answer = 0;
//		for(int i=R-1; i>=0; i--) {
//			visited[i][0] = true;
//			dfsDown(i,0);
//		}
//		answer = Math.max(temp,  answer);
		System.out.println(answer);

	}
	
	public static boolean dfsUp(int row, int col) {
		if(col==C-1) {
			answer++;
			return true;
		}
		
		for(int d=0; d<3; d++) {
			int nr = row+dr[d];
			int nc = col+1;
			if(nr<0||nc<0||nr>=R||nc>=C) continue;
			if(visited[nr][nc]==0&&map[nr][nc]!='x') {
				visited[nr][nc]=1;
				boolean isConnected = dfsUp(nr, nc);
				if(!isConnected) {
					continue;
				}
				return isConnected;
			}
		}
		visited[row][col] = -1;
		return false;
	}
	
//	public static boolean dfsDown(int row, int col) {
//		if(col==C-1) {
//			answer++;
//			return true;
//		}
//		
//		for(int d=2; d>=0; d--) {
//			int nr = row+dr[d];
//			int nc = col+1;
//			if(nr<0||nc<0||nr>=R||nc>=C) continue;
//			if(!visited[nr][nc]&&map[nr][nc]!='x') {
//				visited[nr][nc] = true;
//				boolean isConnected = dfsDown(nr, nc);
//				if(!isConnected) {
//					visited[nr][nc] = false;
//					continue;
//				}
//				return isConnected;
//			}
//		}
//		return false;
//	}

}