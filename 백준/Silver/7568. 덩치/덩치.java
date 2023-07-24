import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] wh = new int [n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wh[i][0] = Integer.parseInt(st.nextToken());
			wh[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		int[] rank = new int [n];
		
		for(int i=0; i<n; i++) {
			rank[i] = 1;
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1;j<n;j++) {
				if(wh[i][0]>wh[j][0] && wh[i][1]>wh[j][1]) {
					rank[j]++;
				} else if(wh[i][0]<wh[j][0] && wh[i][1]<wh[j][1]) {
					rank[i]++;
				}
			}
		}
		for(int r : rank) {
			System.out.print(r + " ");
		}
		
	}

}
