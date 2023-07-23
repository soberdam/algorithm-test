import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int level = 0;
			int order = 1;
			for(int j=1; j<=n; j++) {
				level++;
				if(level>h) {
					level = 1;
					order++;
				}
				
			}
			System.out.printf("%d%02d\n", level, order);
			
		}
		
		
		
		
 	}
	

}

