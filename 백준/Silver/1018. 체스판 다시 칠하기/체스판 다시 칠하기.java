import java.io.*;
import java.util.StringTokenizer;




public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		
		// count와 비교할 최솟값
		int min = Integer.MAX_VALUE;
		int bCnt = 0;
		int wCnt = 0;
		int minCnt = 0;
		// 8x8 체스판 black, white
		String[][] bBoard = new String[8][8];
		String[][] wBoard = new String[8][8];

		// 8x8 체스판 칠하기
		for (int f = 0; f < 8; f++) {
			for (int s = 0; s < 8; s++) {
				// 짝수줄, bBoard는 b로 시작, wBoard는 w로 시작
				if (f % 2 == 0) {
					if (s % 2 == 0) {
						bBoard[f][s] = "B";
						wBoard[f][s] = "W";
					} else {
						bBoard[f][s] = "W";
						wBoard[f][s] = "B";
					}
					// 홀수 줄, bBoard는 W로 시작, wBoard는 b로 시작
				} else {
					if (s % 2 == 0) {
						bBoard[f][s] = "W";
						wBoard[f][s] = "B";
					} else {
						bBoard[f][s] = "B";
						wBoard[f][s] = "W";
					}
				}
			}
		}
		
		
		// 체스보드 입력판
		String[][]chessBoard = new String [n][m];
		for(int a = 0; a < n; a++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			String str = st2.nextToken();
			for(int b = 0; b < m; b++) {
				
				chessBoard[a][b] = Character.toString(str.charAt(b));
			}
		}
		// 8x8을 만들 수 있는 경우의 수는 y, x의 인덱스가 m-7, n-7까지 가능
		// i와 j는 시작점
		for(int i = 0;i<n-7;i++) {
			
			for (int j = 0; j < m-7; j++) {
				bCnt = 0;
				wCnt = 0;
				//시작점에서 8x8 사각형과 체스판 8x8 사각형을 비교
				for(int k=0; k<8; k++) {
					for(int l=0; l<8; l++) {
						if (!(chessBoard[i+k][j+l].equals(bBoard[k][l]))) {
							bCnt++;
						}
						
						if (!(chessBoard[i+k][j+l].equals(wBoard[k][l]))) {
							wCnt++;
						}
						
					}
				} 
				minCnt = Math.min(bCnt, wCnt);
				min = Math.min(min, minCnt);
			}
			
			
		}
		
		
		
		bw.write(String.valueOf(min));
		bw.flush();
		bw.close();
	}

}
