
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int distance = 0;
			int speed = 0;
			int boost = 0;
			for(int i=0; i<N; i++) {
				int command = sc.nextInt();
				switch(command) {
				case 1: 
					boost = sc.nextInt();
					speed += boost;
					break;
				case 2:
					boost = sc.nextInt();
					if(speed<boost) {
						speed = 0;
					} else {
						speed -= boost;
					}
					break;
				case 0:
					break;
				}
				distance += speed;
			}
			System.out.printf("#%d %d\n", test_case, distance);
		}
	}
}