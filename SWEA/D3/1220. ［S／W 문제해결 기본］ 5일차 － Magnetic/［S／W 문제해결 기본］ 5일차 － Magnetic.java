
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int r = sc.nextInt();
			int[][] arr = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int count =0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					// 2가 먼저 나오면 계속
					if(arr[j][i] == 2) {
						continue; 
					}
					// 1이 나왔을 때 끝까지 가도 없거나 다음 나오는 조각이 1이면 계속
					if(arr[j][i]==1) {
						for(int k=j+1; k<100; k++) {
							if(arr[k][i]==1) {
								j = k-1;
								break; 
							}
							if(arr[k][i]==2) {
								count++; 
								j = k;
								break;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, count);
		}
	}
}