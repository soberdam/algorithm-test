/*
 * 입력 조건 : 첫째 줄에 정수 N이 입력됩니다. (0 <= N <= 23)
 * 출력 조건 : 00시 00분 00초부터 N시 59분 59초까지 모든 시각중에서 3이 하나라도 포함되는 모든 경우의 수를 출력합니다.
 */
package Implementation;
import java.util.*;
public class Time {
	public static boolean check(int h, int m, int s) {
		if(h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int h = scanner.nextInt();
		int cnt = 0;
		
		for(int i=0; i<=h; i++) {
			for(int j=0; j<60; j++) {
				for(int k=0; k<60; k++) {
					if (check(i, j, k)) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
