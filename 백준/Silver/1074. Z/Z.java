import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int ans = recursive(N, r, c);
		System.out.println(ans);
	} 
	
	public static int recursive(int N, int row, int col) {
		if(N==0) {
			return 0;
		}
		int smallR = (int)Math.pow(2, N-1);
		int half = smallR*smallR;
		if(row<smallR&&col<smallR) {
			return recursive(N-1, row, col);
		} else if(row<smallR&&col>=smallR) {
			return half + recursive(N-1, row, col-smallR);
		} else if(row>=smallR&&col<smallR) {
			return half*2 + recursive(N-1, row-smallR, col);
		} else {
			return half*3 + recursive(N-1, row-smallR, col-smallR);
		}
		
	}
}