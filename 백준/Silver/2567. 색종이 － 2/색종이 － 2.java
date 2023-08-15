import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[101][101];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					board[y+j][x+k] = 1;
				}
			}

		}
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		int count = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (board[i][j] == 1) {
					int temp = 0;
					for(int d=0; d<4; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];
						if(nx>=0 && nx<101 && ny>=0 && ny<101) {
							if (board[ny][nx]==0) {
								temp++;
							}
						}
					}
					if(temp==1) {
						count += 1;
					} else if (temp>=2) {
						count += 2;
					}
				}
			}
		}
		System.out.println(count);

	}

}

