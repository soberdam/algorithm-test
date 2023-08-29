
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			StringBuilder code = new StringBuilder();
			String[] deCoding = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111",
					"0111011", "0110111", "0001011" };
			Loop1: for (int i = 0; i < N; i++) {
				Loop2: for (int j = 0; j < M - 56; j++) {
					boolean isChecked = false;
					int idx = 0;
					Loop3: for (int k = 0; k < 8; k++) {
						boolean isCode = false;
						StringBuilder sb = new StringBuilder();
						for (int l = 0; l < 7; l++) {
							sb.append(arr[i][j + idx++]);
						}
						for (int d = 0; d < 10; d++) {
							if (deCoding[d].equals(sb.toString())) {
								isCode = true;
								isChecked = true;
								code.append(d);
								continue Loop3;
							}
						}
						if (!isCode) {
							isChecked = false;
							code.setLength(0);
							continue Loop2;
						}
					}
					if (isChecked)
						break Loop1;
				}
			}
			int ans = isCorrectCode(code.toString());

			System.out.printf("#%d %d\n", test_case, ans);

		}
	}

	public static int isCorrectCode(String code) {
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0; i < 8; i++) {
			if ((i + 1) % 2 == 1)
				oddSum += (code.charAt(i) - '0');
			else
				evenSum += (code.charAt(i) - '0');
		}
		int sum = oddSum*3+evenSum;
		return sum%10==0? oddSum+evenSum : 0;
	}
}