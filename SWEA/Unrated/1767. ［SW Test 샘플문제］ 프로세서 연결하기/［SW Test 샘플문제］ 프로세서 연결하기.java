import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int N;
	static int[][] board;
	static int maxCore;
	static int minSumLen;
	static List<Point> coreList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			coreList = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j]==1) coreList.add(new Point(i, j));
				}
			}
			maxCore = 0;
			minSumLen = Integer.MAX_VALUE;
			
			backTracking(0, 0, 0, board);
			
			System.out.printf("#%d %d\n", tc, minSumLen);
		}
	}
	
	public static void backTracking(int depth, int coreCnt, int total, int[][] board) {
		// 코어를 모두 확인했다면 return
		if(depth==coreList.size()) {
			if(coreCnt>maxCore) {
				maxCore = coreCnt;
				minSumLen = total;
			}
			if (coreCnt==maxCore) {
				minSumLen = Math.min(minSumLen, total);
			}
			return;
		}
		// 남은 체크해야할 코어를 모두 체크해도 최대 코어 수보다 작다면 return
		if(coreCnt + coreList.size()-depth<maxCore) return;
		
			Point core = coreList.get(depth);
			
			// 가장자리에 있는 코어라면 이미 연결되어 있다.
			if (core.x==0 || core.y==0) {
				backTracking(depth+1, coreCnt+1, total, board);
			}
			else {
				// 4방향을 그려보며 재귀한다.
				for(int d=0; d<4; d++) {
					int r = core.x;
					int c = core.y;
					// 전선을 그어볼 임시 배열
					int[][] temp = new int[N][N];
					for(int j=0; j<N; j++) {
						temp[j] = board[j].clone();
					}
					boolean connected = false;
					int sum = 0;
					while(true) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						// 끝까지 이동한다면 연결 O
						if(nr<0||nc<0||nr>=N||nc>=N) {
							connected = true;
							break;
						}
						// 이동 중간에 전선이나 프로세서가 있다면 연결 X
						if(temp[nr][nc]!=0) {
							connected = false;
							break;
						}
						temp[nr][nc] = 2;
						sum++;
						r = nr;
						c = nc;
					}
					if(connected) {
						backTracking(depth+1, coreCnt+1, total+sum, temp);
					} else {
						backTracking(depth+1, coreCnt, total, board);
					}
				}
			}
		
		
	}





}
