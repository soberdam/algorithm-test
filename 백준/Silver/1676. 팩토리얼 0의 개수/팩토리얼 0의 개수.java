import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		
		while(true) {
			if(N/5!=0) {
			answer += N/5;
			N /= 5;
			} else {
				break;
			}
		}
		System.out.println(answer);
	}

}
