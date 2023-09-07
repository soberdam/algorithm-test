import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] isNotPrime = new boolean[M+1];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		for(int i=2; i<=Math.sqrt(M); i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i; j<=M; j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
		
		for(int i=N; i<=M; i++) {
			if(!isNotPrime[i]) {
				bw.write(String.valueOf(i));
				bw.write('\n');
			}
		}
		bw.close();
	}

}