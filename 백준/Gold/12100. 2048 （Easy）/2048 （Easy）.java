import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 *
 */



public class Main {
	
	static int N;
	static int maxBlock = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backTracking(arr,0);
		System.out.println(maxBlock);
	}
	// 5번 이동하는 겨웅의 수
	public static void backTracking(int[][] arr, int count) {
		if(count==5) {
			maxBlock = Math.max(maxBlock, findMaxBlock(arr));
			return;
		}
		
		backTracking(moveUp(arr), count+1);
		backTracking(moveDown(arr), count+1);
		backTracking(moveLeft(arr), count+1);
		backTracking(moveRight(arr), count+1);
	}
	
	// 블럭을 위로 이동한다.
	public static int[][] moveUp(int[][] arr) {
		int[][] temp = new int[N][N];
		boolean[][] merged = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[j][i] = arr[j][i];
				if(arr[j][i]!=0&&j>0) {
					int idx = j;
					while(idx-1>=0&&temp[idx-1][i]==0) {
						temp[idx-1][i] = temp[idx][i];
						temp[idx][i] = 0;
						idx--;
					}
					if(idx-1>=0&&temp[idx-1][i]==temp[idx][i]&&!merged[idx-1][i]) {
						temp[idx-1][i] *=2;
						temp[idx][i] = 0;
						merged[idx-1][i] = true;
					}
				}
			}
		}
		return temp;
	}
	
	// 블럭을 아래로 이동한다.
	public static int[][] moveDown(int[][] arr) {
		int[][] temp = new int[N][N];
		boolean[][] merged = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				temp[j][i] = arr[j][i];
				if(arr[j][i]!=0&&j<N-1) {
					int idx = j;
					while(idx+1<N && temp[idx+1][i]==0) {
						temp[idx+1][i] = temp[idx][i];
						temp[idx][i] = 0;
						idx++;
					}
					if(idx+1<N&&temp[idx+1][i]==temp[idx][i]&&!merged[idx+1][i]) {
						temp[idx+1][i] *=2;
						temp[idx][i] = 0;
						merged[idx+1][i] = true;
					}
				}
			}
		}
		return temp;
	}
	
		// 블럭을 왼쪽으로 이동한다.
		public static int[][] moveLeft(int[][] arr) {
			int[][] temp = new int[N][N];
			boolean[][] merged = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp[i][j] = arr[i][j];
					if(arr[i][j]!=0&&j>0) {
						int idx = j;
						while(idx-1>=0 && temp[i][idx-1]==0) {
							temp[i][idx-1] = temp[i][idx];
							temp[i][idx] = 0;
							idx--;
						}
						if(idx>0&&temp[i][idx-1]==temp[i][idx]&&!merged[i][idx-1]) {
							temp[i][idx-1] *=2;
							temp[i][idx] = 0;
							merged[i][idx-1] = true;
						}
					}
				}
			}
			return temp;
		}
		
		// 블럭을 오른쪽으로 이동한다.
		public static int[][] moveRight(int[][] arr) {
			int[][] temp = new int[N][N];
			boolean[][] merged = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--) {
					temp[i][j] = arr[i][j];
					if(arr[i][j]!=0&&j<N-1) {
						int idx = j;
						while(idx+1<N && temp[i][idx+1]==0) {
							temp[i][idx+1] = temp[i][idx];
							temp[i][idx] = 0;
							idx++;
						}
						if(idx+1<N&&temp[i][idx+1]==temp[i][idx]&&!merged[i][idx+1]) {
							temp[i][idx+1] *=2;
							temp[i][idx] = 0;
							merged[i][idx+1] = true;
						}
					}
				}
			}
			return temp;
		}
	
	// 최대 크기의 블럭을 찾아 리턴한다.
	public static int findMaxBlock(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]!=0) max=Math.max(max, arr[i][j]);
			}
		}
		return max;
	}
}
