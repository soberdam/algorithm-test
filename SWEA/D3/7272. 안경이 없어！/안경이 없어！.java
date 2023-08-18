
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String answer = "SAME";
			String first = sc.next();
			String second = sc.next();
			String c1 = "CEFGHIJKLMNSTUVWXYZ";
			String c2 = "ADOPQR";
			String c3 = "B";
			if(first.length()!=second.length()) {
				System.out.printf("#%d %s\n", test_case, "DIFF");
				continue;
			}
			for(int i=0; i<first.length(); i++) {
				String s1 = String.valueOf(first.charAt(i));
				String s2 = String.valueOf(second.charAt(i));
				
				if(c1.contains(s1)) {
					if(c1.contains(s2)) {
						continue;
					} else {
						answer = "DIFF";
						break;
					}
				} else if(c2.contains(s1)) {
					if(c2.contains(s2)) {
						continue;
					} else {
						answer = "DIFF";
						break;
					}
				} else {
					if(c3.contains(s2)) {
						continue;
					} else {
						answer = "DIFF";
						break;
					}
				}
			}
			
			System.out.printf("#%d %s\n", test_case, answer);

		}
	}
}