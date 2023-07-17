import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int multi = 1;
		for (int i = 0; i < 3; i++) {
			int num = sc.nextInt();
			multi *= num;
		}
		int[] arr = new int[10];
		String sMulti = "" + multi;
		for (int j = 0; j < sMulti.length(); j++) {
			int index = sMulti.charAt(j) - '0';
			arr[index]++;
		}
		for (int count : arr) {
			System.out.println(count);
		}

	}
}