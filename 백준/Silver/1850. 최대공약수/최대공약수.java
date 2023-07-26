
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long a = 0;
		long b = 0;
		if(A>B) {
			a = A;
			b = B;
		} else {
			a = B;
			b = A;
		}
		long r = Long.MAX_VALUE;
		while(r!=0) {
			r = a%b;
			
			a = b;
			b = r;
		}		
		long gcd = a;
		StringBuilder sb = new StringBuilder();
		for(long i=0; i<gcd; i++) {
			sb.append("1");
		}
		System.out.println(sb.toString());
		
	}
}


