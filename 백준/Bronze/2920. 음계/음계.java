import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String answer = "";
		String str = "";
		String[] strArr = sc.nextLine().split(" ");
		for (String s : strArr) {
			str += s;
		}
		
		if(str.equals("12345678")) {
			answer = "ascending";
		} else if (str.equals("87654321")) {
			answer = "descending";
		} else {
			answer = "mixed";
		}
		
		System.out.print(answer);

	}
}