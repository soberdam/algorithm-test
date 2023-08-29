import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static int N;
	static int M;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		binarySearch(0, 1000000000);
		System.out.println(max);
	}
	
	public static void binarySearch(int start, int end) {
		while(start<=end) {
			int mid = (start+end)/2;
			long treeCnt = cut(mid);
			if(treeCnt == M) {
				max = mid;
				return;
			}
			
			if(treeCnt<M) {
				end = mid-1;
			}
			
			if(treeCnt>M) {
				max = mid;
				start = mid+1;
			}
		}
	}
	
	public static long cut(int height) {
		long sum = 0;
		for(int i=0; i<N; i++) {
			if(arr[i]>height) {
				sum += (arr[i] - height);
			}
		}
		return sum;
	}
	

}
