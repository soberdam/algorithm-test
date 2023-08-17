import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 시험장 별 학생 수
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독관 관리학생 수
		int C = Integer.parseInt(st.nextToken()); // 부감독관 관리학생 수
		
		long answer = 0;
		
		for(int i=0; i<N; i++) {
			// 총감독 한명으로 커버 가능하면
			if(arr[i]<=B) { 
				answer++;
				continue;
			}
			// 부감독이 필요하면
			answer++; // 총감독 추가
			if((arr[i]-B)%C==0) { 
				answer += ((arr[i]-B)/C);
			} else {
				answer += ((arr[i]-B)/C+1);
			}
		}
		
		System.out.println(answer);
		
	}

}
