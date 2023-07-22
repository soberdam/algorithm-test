import java.io.*;
public class Main {
		// 1초 = 연산 1억번
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long [n+1];
		arr[1]=5L;
		for(int i=2; i<=n; i++) {
			arr[i] = arr[i-1] + (i*3+1);
		}
		
		System.out.println(arr[n]%45678L);
		
		
 	}
	

}

