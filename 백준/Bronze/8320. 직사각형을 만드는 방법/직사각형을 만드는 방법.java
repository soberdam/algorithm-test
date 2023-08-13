
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 1;
		
		for(int i=2; i<=n; i++) {
			int count = 1;
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(j*j==i) count++;
				if(i%j==0 && j<Math.sqrt(i)) count++;
			}
			sum+=count;
		}
		
		System.out.println(sum);
		
		
		
		
	}
	
	
		

}
