import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashMap <Integer, Integer> map = new HashMap();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				continue;
			} else {
				map.put(num, 1);
			}
		}
		
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int j=0; j<m; j++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				bw.write(1 + "\n");
			} else {
				bw.write(0 + "\n");
			}
		}
		
		bw.flush();
		bw.close();
 	}
	

}

