import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int count = 0;
			String original = sc.next();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < original.length(); i++) {
				sb.append("0");
			}
			String reset = sb.toString();
			for (int i = 0; i < reset.length(); i++) {
				if (reset.equals(original))
					break;
				else if (reset.charAt(i) == '0' && original.charAt(i) == '1') {
					
					sb.setLength(0);
					for(int j = i; j<reset.length(); j++) {
						sb.append("1");
					}
					reset = reset.substring(0, i).concat(sb.toString());
					count++;
				}

				else if (reset.charAt(i) == '1' && original.charAt(i) == '0') {
					sb.setLength(0);
					for(int j = i; j<reset.length(); j++) {
						sb.append("0");
					}
					reset = reset.substring(0, i).concat(sb.toString());
					count++;
				}
			}

			System.out.printf("#%d %d\n", test_case, count);
		}
	}

}