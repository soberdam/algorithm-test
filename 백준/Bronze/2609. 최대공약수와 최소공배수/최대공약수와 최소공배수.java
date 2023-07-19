import java.util.Scanner;
public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int gcd = 0;
		int lcm = 0;
		int n1 = a;
		int n2 = b;
		while(n2!=0) {
			int r = n1%n2;
			n1=n2;
			n2=r;
		}
		gcd = n1;
		lcm = a*b/gcd;
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
}