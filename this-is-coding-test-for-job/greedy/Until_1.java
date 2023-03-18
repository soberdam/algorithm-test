/*
 * 어떠한 수 N이 1이 될 때까지 다음의 두 과정중 하나를 반복적으로 선택하여 수행합니다. 단, 두번째 연산은 N이 K로 나누어 떨어질 때만 선택할 수 있습니다.
 * 1. N에서 1을 뺍니다.
 * 2. N을 K로 나눕니다.
 * 입력 조건 : 첫째 줄에 N과 K가 공백을 기준으로 하여 각각 자연수로 주어진다.
 * 출력 조건 : 첫째 줄에 N이 1이 될 때까지 1번 혹은 2번의 과정을 수행해야 하는 최솟값을 출력한다.
 */

package greedy;

import java.util.*;

public class Until_1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int result = 0;

		while (true) {
			int target = (n / k) * k; 
			result += (n-target);
			n = target;
			if (n < k)
				break;
			result += 1;
			n /= k;
		}
		
		result += (n-1);
		System.out.println(result);

	}

}
