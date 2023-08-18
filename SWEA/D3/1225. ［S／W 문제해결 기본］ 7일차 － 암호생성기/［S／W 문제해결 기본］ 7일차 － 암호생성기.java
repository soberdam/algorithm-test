
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tNum = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			// 한 싸이클
			Loop1 : while (true) {
				// 1부터 5까지 감소시킨다.
				for(int i=1; i<=5; i++) {
					int first = queue.poll();
					first -= i;
					if (first <= 0) {
						queue.offer(0);
						break Loop1;
					}
					queue.offer(first);
				}
			}
			
			System.out.printf("#%d", tNum);
			while(!queue.isEmpty()) {
				System.out.print(" " + queue.poll());
			}
			System.out.println();
		}
	}
}