import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
		}
		Arrays.sort(arr, (o1, o2) -> {
		if(o1[0]==o2[0]) return o1[1]-o2[1];
		else return o1[0]-o2[0]; 
		});
		
		for(int[] xy : arr) {
			System.out.println(xy[0] + " " + xy[1]);
		}
		
	}

}
