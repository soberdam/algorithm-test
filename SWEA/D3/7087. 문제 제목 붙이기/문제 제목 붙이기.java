
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int answer = 0;
			boolean[] alphabets = new boolean[26]; 
			for(int i=0; i<N; i++) {
				char c = sc.next().charAt(0);
				alphabets[c-'A'] = true;
			}
			
			for(int i=0; i<26; i++) {
				if(alphabets[i]) {
					answer++;
				} else {
					break;
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}