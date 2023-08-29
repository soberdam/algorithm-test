import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] arr = new double[N];
		for(int i=0; i<N; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
		}
		
		Arrays.sort(arr);
		double max = arr[N-1];
		for(int i=0; i<N-1; i++) {
			max += arr[i]/2.0;
		}
		
		System.out.println(max);
		
	}
	
}
