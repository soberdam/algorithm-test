/*
 * 각 자리가 숫자(0~9)로만 이루어진 문자열 S가 주어졌을 때, 왼쪽부터 오른쪽으로 하나씩 모든 숫자를 확인하며 숫자 사이에
 * '*' 혹은 '+' 연산자를 넣어 결과적으로 만들어질 수 있는 가장 ㅡㅋㄴ 수를 구하는 프로그램을 작성하세요.
 * 단, 일반적인 연산자 우선순위와 달리 모든 연산은 왼쪽에서부터 순서대로 이루어진다고 가정합니다.
 */

package greedy;
import java.util.Scanner;

public class Multiply_Or_Plus {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int result = s.charAt(0) - '0';
		
		for(int i = 1; i < s.length(); i++) {
			int num = s.charAt(i) - '0';
			
			if(result <= 1 || num <= 1 ) {
				result += num;
			} else {
				result *= num;
			}
			
		}
		
		System.out.println(result);
	}

}
