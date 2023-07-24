import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] apartment = new int [k+1][n+1];
			// 0층
			for(int j=1; j<=n; j++) {
				apartment[0][j] = j;
			}
			
			//아파트에 주민 수 삽입
			for(int a=1;a<k+1;a++) {
				for(int b=1; b<=n; b++) {
					int sum = 0;
					
					// a-1층의 1호부터 b호까지의 주민 수
					for(int c = 1; c<=b; c++) {
						sum += apartment[a-1][c];
					}
					//호수 대입
					apartment[a][b] = sum;
					
				}
			}
			System.out.println(apartment[k][n]);
			
		}
	}

}
