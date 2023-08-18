
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
			Queue<Integer> q = new LinkedList<>();
			int idx = 1;
			int first = 0;
			int[] check = new int [N+1];
			while(true) {
				q.offer(idx); // 줄을 선다.
				first = q.poll(); // 마이쮸를 받을 사람.
				N-=++check[first]; // 해당 사람이 받은 횟수만큼 마이쮸를 받는다.
				if(N<=0) {
					break;
				}
				q.offer(first); // 마이쮸를 받고나면 줄을 선다.
				idx++;
			}
			
			System.out.printf("#%d %d\n", test_case, first);
			
		}
	}
}