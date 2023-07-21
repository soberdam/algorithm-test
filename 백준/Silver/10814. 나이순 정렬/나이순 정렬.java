import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;




public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [][] members = new String [n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			members[i][0] = st.nextToken();
			members[i][1] = st.nextToken();
		}
		
		Arrays.sort(members, (o1, o2) -> {
			if(o1[0]==o2[0])
				return 0;
			else 
				return (Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));
			
		});
		
		
		for(int j=0; j<n; j++) {
			System.out.println(members[j][0] + " " + members[j][1]);
		}
	}

}
