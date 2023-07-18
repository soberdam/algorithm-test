import java.util.Scanner;

public class Main {
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int answer = factorial(n)/(factorial(n-k)*factorial(k));
		System.out.println(answer);
	}
    
    public static int factorial(int num) {
		if (num == 1 || num == 0) return 1;
		else {
			return factorial(num-1) * num;
		}
		
	}
	

}