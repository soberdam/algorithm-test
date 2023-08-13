
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 참가 학생 수 
		int k = Integer.parseInt(st.nextToken()); // 한방에 배정 가능한 최대 인원 수
		int[][] students = new int [2][6];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 성별
			int y = Integer.parseInt(st.nextToken()); // 학년
			students[s][y-1]++;
		}
		
		int count = 0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<6; j++) {
				if(students[i][j]!=0) {
					count+=(students[i][j]+1)/2;
				}
			}
		}
		System.out.println(count);
		
	}
	
	
		

}
