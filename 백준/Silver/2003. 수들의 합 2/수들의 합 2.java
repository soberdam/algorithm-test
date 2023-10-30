import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		int end = 0;
		int intervalSum = 0;
		for(int start=0; start<N; start++) {
			
			while(end<N&&intervalSum<M) {
				intervalSum += arr[end];
				end++;
			}
			
			if(intervalSum==M) count++;
			
			intervalSum -= arr[start];
		}
		
		System.out.println(count);
	}
}
