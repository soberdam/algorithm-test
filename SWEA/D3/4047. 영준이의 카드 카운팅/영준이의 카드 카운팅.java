
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		Loop1: for (int test_case = 1; test_case <= T; test_case++) {
			boolean[] cardS = new boolean[13];
			boolean[] cardD = new boolean[13];
			boolean[] cardH = new boolean[13];
			boolean[] cardC = new boolean[13];

			String s = sc.next();
			for (int i = 0; i < s.length(); i += 3) {
				char shape = s.charAt(i);
				int num = Integer.parseInt("" + s.charAt(i+1) + s.charAt(i+2));
				switch (shape) {
				case 'S':
					if(cardS[num-1]) {
						System.out.println("#" + test_case + " ERROR");
						continue Loop1;
					} else {
						cardS[num-1] = true;
					}
					break;
				case 'D':
					if(cardD[num-1]) {
						System.out.println("#" + test_case + " ERROR");
						continue Loop1;
					} else {
						cardD[num-1] = true;
					}
					break;
				case 'H':
					if(cardH[num-1]) {
						System.out.println("#" + test_case + " ERROR");
						continue Loop1;
					} else {
						cardH[num-1] = true;
					}
					break;
				case 'C':
					if(cardC[num-1]) {
						System.out.println("#" + test_case + " ERROR");
						continue Loop1;
					} else {
						cardC[num-1] = true;
					}
					break;
				}
			}

			int countS = 13;
			int countD = 13;
			int countH = 13;
			int countC = 13;
			for (int i = 0; i < 13; i++) {
				if (cardS[i]) {
					countS--;
				}
				if (cardD[i]) {
					countD--;
				}
				if (cardH[i]) {
					countH--;
				}
				if (cardC[i]) {
					countC--;
				}
			}

			System.out.printf("#%d %d %d %d %d\n", test_case, countS, countD, countH, countC);
		}
	}
}