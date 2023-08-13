
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 수
		int [][] floor = new int [1001][1001];
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<x+width; j++) {
				for(int k=y; k<y+height; k++) {
					floor[j][k] = i;
				}
			}
			
		}
		for(int k=1; k<=N; k++) {
			int count = 0;
			for(int i=0; i<1001; i++) {
				for(int j=0; j<1001; j++) {
					if(floor[i][j]==k) count++;
						
				}
			}
			System.out.println(count);
		}
		
		
		
		
		
	}

}
