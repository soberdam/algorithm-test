
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 90도 회전 
			int[][] arr90 = new int[N][N];
			int r = 0;
			int c = 0;
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) {
					arr90[r][c++] = arr[j][i];
				}
				r++;
				c = 0;
			}
			
			// 180도 회전
			int[][] arr180 = new int[N][N];
			r = 0;
			c = 0;
			for(int i=N-1; i>=0; i--) {
				for(int j=N-1; j>=0; j--) {
					arr180[r][c++] = arr[i][j];
				}
				r++;
				c = 0;
			}
			
			// 270도 회전
			int[][] arr270 = new int[N][N];
			r = 0;
			c = 0;
			for(int i=N-1; i>=0; i--) {
				for(int j=0; j<N; j++) {
					arr270[r][c++] = arr[j][i];
				}
				r++;
				c = 0;
			}
			
			
			
			System.out.printf("#%d\n", test_case);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				
				for(int j=0; j<N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				
				for(int j=0; j<N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.print(" ");
				
				System.out.println();
			}
		}
	}
}