
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int	D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			boolean[] isNotPrime = new boolean[1000001];
			isNotPrime[0] = true;
			isNotPrime[1] = true;
			
			for(int i=2; i<=Math.sqrt(1000000); i++) {
				if(!isNotPrime[i]) {
					for(int j=i*2; j<=1000000; j+=i) {
						isNotPrime[j] = true;
					}
				}
			}
			for(int i=A; i<=B; i++) {
				if(i==1) continue;
				//소수라면
				if (!isNotPrime[i]) {
					String s = String.valueOf(i);
					for(int j=0; j<s.length(); j++) {
						int num = s.charAt(j) - '0';
						if(num==D) {
							answer++;
							break;
						}
					}
				}
			}
			System.out.printf("#%d %d \n", test_case, answer);
		}
	}
}
