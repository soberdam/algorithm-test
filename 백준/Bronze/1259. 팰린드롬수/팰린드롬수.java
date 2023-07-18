import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = String.valueOf(sc.nextInt());
			if (str.equals("0")) 
				break;
			else {
				StringBuffer sb = new StringBuffer(str);
				String reverse = sb.reverse().toString();
				if(str.equals(reverse)) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		}						
	}

}