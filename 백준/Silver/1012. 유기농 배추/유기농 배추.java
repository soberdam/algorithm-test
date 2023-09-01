import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			boolean[][] cabbages = new boolean[N][M];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				cabbages[row][col] = true;
			}
			int count = 0;
			Stack<int[]> stack = new Stack<>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(cabbages[i][j]) {
						stack.push(new int[] {i,j});
						cabbages[i][j] = false;
						Loop1 : while(!stack.isEmpty()) {
							int[] rc = stack.peek();
							int row = rc[0];
							int col = rc[1];
							for(int d=0; d<4; d++) {
								int nr = row+dr[d];
								int nc = col+dc[d];
								if(nr>=0&&nr<N&&nc>=0&&nc<M&&cabbages[nr][nc]) {
									stack.push(new int[] {nr, nc});
									cabbages[nr][nc] = false;
									continue Loop1;
								}
							}
							stack.pop();
						}
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
