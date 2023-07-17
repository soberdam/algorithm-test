import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] strs = s.split("[\\+|\\-]");
		int[] numbers = new int[strs.length];
		int idx = 0;
		int sum = 0;

		for (int j = 0; j < strs.length; j++) {
			numbers[j] = Integer.valueOf(strs[j]);
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '+') {
				idx++;
			} else if (s.charAt(i) == '-') {
				idx++;
				for (int k = idx; k < numbers.length; k++) {
					if (numbers[k] > 0)
						numbers[k] *= -1;
				}
			}
		}

		for (int num : numbers) {
			sum += num;
		}

		System.out.println(sum);

	}
}
