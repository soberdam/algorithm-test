import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=1; i<=n; i++) {
			String str = String.valueOf(i);
			int sum = 0; // 각 자릿수의합
			for(int j=0; j<str.length(); j++) {
				sum += str.charAt(j) - '0';
			}
			if(i + sum == n) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
		
	}

}
