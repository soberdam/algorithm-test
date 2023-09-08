import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
 * 2. 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다. 
 * 2-1.스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다. 가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
 * 3. 선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
 * 4. 위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.
 */
public class Main {
	static int[][] notebook;
	static int[][] sticker;
	static int N;
	static int M;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		notebook = new int[N][M];

		int K = Integer.parseInt(st.nextToken());
		Loop1: for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			sticker = new int[row][col];
			for (int r = 0; r < row; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < col; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 4;
			while (count-- > 0) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (checkPostable(r, c)) {
							post(r, c);
//							for(int k=0; k<N; k++) {
//								for(int j=0; j<M; j++) {
//									System.out.print(notebook[k][j]);
//								}
//								System.out.println();
//							}
//							System.out.println("------");
							continue Loop1;
						}
					}
				}
				rotate();
			}

		}
		
		System.out.println(answer);
	}

	// 스티커를 붙일 수 있는지 확인하는 메소드
	public static boolean checkPostable(int startR, int startC) {
		if(startR>N-sticker.length || startC>M-sticker[0].length) return false;
		for(int i=0; i<sticker.length; i++) {
			for(int j=0; j<sticker[0].length; j++) {
				if(notebook[startR+i][startC+j]==1 && sticker[i][j]==1) return false;
			}
		}
		
		return true;
	}

	// 스티커를 회전하는 메소드
	public static void rotate() {
		int row = sticker[0].length;
		int col = sticker.length;
		int[][] temp = new int[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				temp[i][j] = sticker[sticker.length-1-j][i];
			}
		}
		sticker = temp;
	}
	
	public static void post(int startR, int startC) {
		for(int i=0; i<sticker.length; i++) {
			for(int j=0; j<sticker[0].length; j++) {
				if(sticker[i][j]==1) {
					notebook[startR+i][startC+j] = 1;
					answer++;
				}
			}
		}
	}
}