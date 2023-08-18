
import java.util.Scanner;

class Solution {
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][];
			
			for(int i=0; i<N; i++) {
				arr[i] = new int[i+1];
			}
			
			
			System.out.printf("#%d\n", test_case);
			arr[0][0] = 1;
			System.out.println(1);
			for(int i=1; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					if(j==0 || j == arr[i].length-1) {
						arr[i][j] = 1;
					} else {
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
			
			
		}
	}
}