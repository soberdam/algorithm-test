import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean bool = false;
		int answer = -1;

		Loop1: for (int i = n / 5 * 5; i >= 5; i -= 5) {
			// 1. 5로 나누어질때
			if (n - i == 0) {
				answer = i / 5;
				bool = true;
				break Loop1;
			}

			// 2. 5의 배수로 나눈 나머지가 3의 배수으로 나누어질때
			for (int j = n / 3 * 3; j >= 3; j -= 3) {

				if ((n - i) - j == 0) {
					answer = i / 5 + j / 3;
					bool = true;
					break Loop1;
				}

			}

		}
		// 3. 3으로 나누어질 때
		if (!bool) {
			for (int j = n / 3 * 3; j >= 3; j -= 3) {
				if (n % j == 0) {
					answer = j / 3;
					break;
				}
			}
		}
		
		System.out.println(answer);

	}

}
