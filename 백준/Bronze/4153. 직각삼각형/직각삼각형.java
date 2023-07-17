import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int a = 0, b = 0, c = 0;
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		while (true) {
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			arr[2] = sc.nextInt();
			Arrays.sort(arr);
			a = arr[0];
			b = arr[1];
			c = arr[2];
			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			if (a * a + b * b == c * c) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}

		sc.close();
	}
}