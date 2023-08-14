import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 스위치의 개수
		boolean[] switches = new boolean[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				switches[i] = true;
			}
		}

		int stdNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < stdNum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());

			// 남학생일 경우
			if (sex == 1) {
				for (int j = 1; j <= n; j++) {
					// j번째가 배수이면 j-1번 인덱스의 스위치 전환
					if (j % point == 0) {
						switches[j - 1] = !switches[j - 1];
					}
				}
			}
			// 여학생일 경우
			else {
				int start = point - 1;
				int end = point - 1;
				// 좌우 대칭이 어디까지인지 확인
				while (true) {
					start--;
					end++;
					if ((start< 0 || end>= n) || switches[start] != switches[end]) {
						start++;
						end--;
						break;
					}
	
				}
				for(int j = start; j <= end; j++) {
					switches[j] = !switches[j];
				}
			}
		}
		int count = 0;
		for(int i=0; i<n; i++) {
			if(switches[i]) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}
			if(++count%20 == 0) {
				sb.append("\n");
			}
			
		}
		bw.write(sb.toString());
		bw.close();

	}
}
