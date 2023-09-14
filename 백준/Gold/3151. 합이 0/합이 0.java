import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 1. 백트래킹으로 모든 경우의 수를 확인하면 부분집합의 개수 n*n-1*n-2개를 모두 확인해보아야 한다.
 * 1-1. n이 최대 1만이므로 1만 * 9999 * 9998번 연산하면 시간초과.
 * 1-2. 시간 복잡도는 O(n^3)
 * 
 * 2. 2명의 값을 정하기 위해 N^2번 탐색하고, 나머지 하나의 값을 찾기 위해 이분탐색한다.
 * 2-1. N-2개의 수중 나머지 하나의 값이 있는 경우 그 개수만큼 총 개수에 더해준다.
 * 2-2. 시간복잡도는 O(N^2 * logN)
 * 
 * 3. 하나의 값을 리스트 1에서 고정하며 탐색하고O(N), 나머지 두개의 값을 투포인터O(N)를 이용하여 찾는다.
 * 3-2. 시간복잡도는 O(N^2)
 */



public class Main {
	
	static int N;
	static int S;
	static int[] arr;
	static ArrayList<Integer> list1 = new ArrayList<>();
	static ArrayList<Integer> list2 = new ArrayList<>();
	static long answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long answer = 0;
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				int val1 = arr[i];
				int val2 = arr[j];
				int target = 0 - (val1+val2);
				int lower = lower_bound(j+1,N,target);
				int upper = upper_bound(j+1,N,target);
				answer+= upper-lower;
				
			}
		}
		System.out.println(answer);
	}
	
	public static int lower_bound(int start, int end, int target) {
		while(start<end) {
			int mid = (start+end)/2;
			if(arr[mid]>=target) {
				end = mid;
			} else {
				start = mid +1;
			}
		}
		return end;
	}
	
	public static int upper_bound(int start, int end, int target) {
		while(start<end) {
			int mid = (start+end)/2;
			if(arr[mid]<=target) {
				start = mid +1;
			} else {
				end = mid;
			}
		}
		return end;
	}
	
	
	
	
	
	
}