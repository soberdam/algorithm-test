

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		long ans = mod(A, B, C);
		System.out.println(ans);
	} 
	
	public static long mod(int A, int B, int C) {
		if(B==1) {
			return A%C;
		}
		long val = mod(A, B/2, C);
		// 2k승일 때
		if(B%2==0) {
			return val*val%C;
		} 
		// 2k+1 승일 때
		else {
			return ((val*val%C)*A)%C;
		}
		
	}
}