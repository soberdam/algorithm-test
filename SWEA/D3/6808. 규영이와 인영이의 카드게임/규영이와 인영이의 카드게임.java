
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
	static int[] selected; // 규영이, 순서 고정
	static int[] unSelected; // 인영이가 가진 카드, 순서 9!가지 경우의 수
	static int win;
	static int lose;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			selected = new int[9];
			unSelected = new int[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				selected[i] = num;
			}

			int idx = 0;
			Loop1: for (int i = 1; i <= 18; i++) {
				for (int j = 0; j < 9; j++) {
					if (selected[j] == i) {
						continue Loop1;
					}
				}
				unSelected[idx++] = i;
			}
			win = 0;
			lose = 0;
			DFS(0, 0, 0);
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
	}
	
	public static void DFS(int sumA, int sumB, int count) {
		if(count==9) {
			if(sumA>sumB) win++;
			else if(sumB>sumA) lose++;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(unSelected[i]!=0) {
				boolean isWin = false;
				int temp = unSelected[i];
				if(selected[count]>unSelected[i]) {
					sumA+= selected[count] + unSelected[i];
					isWin = true;
				}
				else if(selected[count]<unSelected[i]) sumB+= selected[count] + unSelected[i];
				count++;
				unSelected[i] = 0;
				DFS(sumA, sumB, count);
				count--;
				unSelected[i] = temp;
				if(isWin) {
					sumA-= selected[count] + unSelected[i];
				} else {
					sumB-= selected[count] + unSelected[i];
				}
			}
		}
	}
}
