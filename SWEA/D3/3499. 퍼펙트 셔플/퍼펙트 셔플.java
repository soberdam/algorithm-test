
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
			Queue<String> queue1 = new LinkedList<>();
			Queue<String> queue2 = new LinkedList<>();
			Queue<String> queue3 = new LinkedList<>();
			if(N%2==0) {
				for (int i = 1; i <= N/2; i++) {
					queue1.offer(sc.next());
				}
				for(int i = N/2+1; i<=N; i++) {
					queue2.offer(sc.next());
				}
			} else {
				for (int i = 1; i <= N/2+1; i++) {
					queue1.offer(sc.next());
				}
				for(int i = N/2+2; i<=N; i++) {
					queue2.offer(sc.next());
				}
			}
			
			while(!queue1.isEmpty()||!queue2.isEmpty()) {
				if(!queue1.isEmpty()) {
					queue3.offer(queue1.poll());
				}
				
				if(!queue2.isEmpty()) {
					queue3.offer(queue2.poll());
				}
			}
			
			
			System.out.printf("#%d", test_case);
			while(!queue3.isEmpty()) {
				System.out.print(" " + queue3.poll());
			}
			System.out.println();
		}
	}
}