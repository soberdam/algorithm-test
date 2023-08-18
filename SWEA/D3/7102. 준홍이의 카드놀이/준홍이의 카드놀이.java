
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] count = new int[N+M+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					count[i+j]++;
				}
			}
			int max = Integer.MIN_VALUE;
			for(int i=1; i<count.length; i++) {
				if(count[i]>max) max = count[i];
			}
			
			
			System.out.printf("#%d", test_case);
			for(int i=2; i<count.length; i++) {
				if(count[i]==max) System.out.print(" " + i);
			}
			System.out.println();
		}
	}
}