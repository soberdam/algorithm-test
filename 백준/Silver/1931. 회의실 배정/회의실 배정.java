import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			arr[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
		}
		// 끝나는 시간이 빠른 것 중 시작시간이 이전 끝난 시간 이후인 것
		Arrays.sort(arr, ((o1, o2) -> {
			if(o1[1]==o2[1]) {
					return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		}));
		int sum = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			if(arr[i][0]>=end) {
				end = arr[i][1];
				sum++;
			}
		}

		System.out.println(sum);

	} // main

}
