import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		int num = 666;
		while (count != n) {
			num += 1;
			if (String.valueOf(num).contains("666"))
				count++;
		}
		System.out.println(num);
    }
}