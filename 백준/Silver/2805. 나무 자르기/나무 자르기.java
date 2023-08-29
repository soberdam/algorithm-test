/*
2805. 나무 자르기
1. 떡의 개수 N개 중 절단기의 길이 H를 0부터 10억까지 이분탐색하며, 
2-1. 중간값일 때 M미터의 나무를 가져갈 수 있는지 확인
2-2. M미터와 일치한다면 max를 업데이트 후 return ( 높이의 최댓값)
2-3. 필요한 M보다 가져갈 수 있는 나무가 적다면 왼쪽에서 탐색
2-4. 필요한 M보다 가져갈 수 있는 나무가 많다면 max를 업데이트 후 오른쪽에서 탐색
*/
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
