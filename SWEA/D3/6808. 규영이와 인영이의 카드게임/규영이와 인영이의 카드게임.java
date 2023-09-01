
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
	static int[] selected; // 규영이, 순서 고정
	static int[] unSelected; // 인영이가 가진 카드, 순서 9!가지 경우의 수
	static ArrayList<Integer> list; // 순서인 9개를 저장할 곳
	static int win;
	static int lose;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			selected = new int[9];
			unSelected = new int[9];
			list = new ArrayList<Integer>();
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
			DFS();
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
	}
	
	public static void DFS() {
		if(list.size()==9) {
			int sumA=0;
			int sumB=0;
			for(int i=0; i<9; i++) {
				if(selected[i]>list.get(i)) sumA+= selected[i]+list.get(i);
				else if(selected[i]<list.get(i))sumB += selected[i]+list.get(i);
			}
			if(sumA>sumB) win++;
			else if(sumB>sumA) lose++;
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(unSelected[i]!=0) {
				int temp = unSelected[i];
				list.add(temp);
				unSelected[i] = 0;
				DFS();
				list.remove(list.size()-1);
				unSelected[i] = temp;
			}
		}
	}
}
