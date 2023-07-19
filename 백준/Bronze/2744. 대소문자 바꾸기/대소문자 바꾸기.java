import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String answer = "";
		for(int i=0; i<str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) {
				answer += Character.toUpperCase(str.charAt(i));
			} else if (Character.isUpperCase(str.charAt(i))) {
				answer += Character.toLowerCase(str.charAt(i));
			}
		}
		System.out.println(answer);
	}

}