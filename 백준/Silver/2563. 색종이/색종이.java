
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int total = 0;
		boolean[][] board = new boolean[101][101];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					board[y+j][x+k] = true;
				}
			}
		}
		
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(board[i][j]) {
					total++;
				}
			}
		}
		
		
		System.out.println(total);

	}

}