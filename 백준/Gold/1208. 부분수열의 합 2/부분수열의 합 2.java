import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 * 1. 백트래킹으로 모든 경우의 수를 확인하면 부분집합의 개수 2^n개를 확인해 보아야 한다.
 * 1-1. n이 최대 40이므로 2^40개의 경우의 수를 확인해야 하므로 시간초과. O(2^n)
 * 
 * 2. N개의 수를 2개의 그룹으로 나눈 뒤, 각 그룹에서 나올 수 있는 누적합을 백트래킹으로 리스트 1, 2에 추가한다.
 * 2-1. 리스트1과 리스트2를 정렬한다.
 * 2-2. 리스트1에서 하나씩의 누적합에 대해 S에서 뺀 나머지 값이 리스트 2에 있는지 확인한다.
 * 2-3. 있다면, 리스트 1에서 선택한 누적합의 개수 * 리스트 2에서 선택한 누적합의 개수를 더한다.
 * 2-4. 마지막에 공집합을 더한다.
 * 2-5. (2^20 * 2 = 2^21)번 연산 +  (2^20 * log(2*20) =  2^21 * 10)번 연산)
 * 2-6. 대략 O(2^n/2)
 */



public class Main {
	
	static int N;
	static int S;
	static int[] arr1;
	static int[] arr2;
	static ArrayList<Integer> list1 = new ArrayList<>();
	static ArrayList<Integer> list2 = new ArrayList<>();
	static long answer = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr1 = new int[N/2];
		arr2 = new int[N-(N/2)];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N/2; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N/2; i<N; i++) {
			arr2[i-(N/2)] = Integer.parseInt(st.nextToken());
		}
		dfs(arr1, list1, 0, 0);
		dfs(arr2, list2, 0, 0);
		Collections.sort(list1);
		Collections.sort(list2);
		
		twoPointer();
		
		if(S==0) answer--;
		System.out.println(answer);
	}
	
	public static void dfs(int[] arr, ArrayList<Integer> list, int idx, int sum) {
		if(idx==arr.length) {
			list.add(sum);
			return;
		}
		dfs(arr, list, idx+1, sum+arr[idx]);
		dfs(arr, list, idx+1, sum);
	}
	
	public static void twoPointer() {
		int pointL = 0;
		int pointR = list2.size()-1;
		
		while(pointL<list1.size() && pointR>=0) {
			int sum = list1.get(pointL) + list2.get(pointR);
			if(sum==S) {
				long leftCnt = 0;
				int leftValue = list1.get(pointL);
				while(pointL<list1.size() && list1.get(pointL)==leftValue) {
					pointL++;
					leftCnt++;
				}
					
				long rightCnt = 0;
				int rightValue = list2.get(pointR);
				while(pointR>=0 && list2.get(pointR)==rightValue) {
					pointR--;
					rightCnt++;
				}
					
				answer += leftCnt * rightCnt;
			}
			
			if(sum<S) pointL++;
			if(sum>S) pointR--;
		}
	}
	
	
	
	
}
