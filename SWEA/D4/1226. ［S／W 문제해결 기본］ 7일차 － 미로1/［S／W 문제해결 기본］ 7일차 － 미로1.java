import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=0; tc<10; tc++) {
			int answer = 0;
			int tNum = Integer.parseInt(br.readLine());
			int[][] maze = new int[16][16];
			boolean[][] visited = new boolean[16][16];
			int[] depart = {};
			int[] arrival = {};
			for(int i=0; i<16; i++) {
				String line = br.readLine();
				for(int j=0; j<16; j++) {
					maze[i][j] = line.charAt(j)-'0';
					if(maze[i][j]==2) depart = new int[] {i,j};
					if(maze[i][j]==3) arrival = new int[] {i,j};
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			queue.add(depart);
			visited[depart[0]][depart[1]] = true;
			while(!queue.isEmpty()) {
				int[] now = queue.poll();
				int r = now[0];
				int c = now[1];
				if(r==arrival[0]&&c==arrival[1]) {
					answer = 1;
					break;
				}
				for(int d=0; d<4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(nr>=0&&nr<16&&nc>=0&&nc<16&&!visited[nr][nc]&&maze[nr][nc]!=1) {
						visited[nr][nc] = true;
						int[] newArr = {nr, nc};
						queue.add(newArr);
					}
				}
			}
			
			
			System.out.printf("#%d %d\n", tNum, answer);
		}
		
	}

}
