import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV {
    int num;
    int row;
    int col;
    
    CCTV(int num, int row, int col) {
        this.num=num;
        this.row=row;
        this.col=col;
    }
}

public class Main {
    static boolean[][] visible;
    static int N;
    static int M;
    static int min;
    static int cctvCnt;
    static ArrayList<CCTV> cctvList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][M];
        min = Integer.MAX_VALUE;
        cctvList = new ArrayList<CCTV>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]>=1 && arr[i][j]<=5) {
                    cctvList.add(new CCTV(arr[i][j], i, j));
                }
            }
        }
        dfs(0, arr);
        System.out.println(min);
       
    }
    public static void dfs(int count, int[][] arr) {
        if(count==cctvList.size()) {
            min = Math.min(min, countInvisible(arr));
            return;
        }
        
        CCTV cctv = cctvList.get(count);
        int row = cctv.row;
        int col = cctv.col;
        int cctvNum = cctv.num;
        
        switch(cctvNum) {
        case 1:
        	dfs(count+1,lookUp(row,col,arr));
        	dfs(count+1,lookDown(row,col,arr));
        	dfs(count+1,lookLeft(row,col,arr));
        	dfs(count+1,lookRight(row,col,arr));
        	break;
        case 2:
        	dfs(count+1,lookLeft(row,col,lookRight(row,col,arr)));
        	dfs(count+1,lookUp(row,col,lookDown(row,col,arr)));
        	break;
        case 3:
        	dfs(count+1,lookUp(row,col,lookRight(row,col,arr)));
        	dfs(count+1,lookUp(row,col,lookLeft(row,col,arr)));
        	dfs(count+1,lookDown(row,col,lookLeft(row,col,arr)));
        	dfs(count+1,lookDown(row,col,lookRight(row,col,arr)));
        	break;
        case 4:
        	dfs(count+1,lookUp(row,col,lookLeft(row,col,lookRight(row,col,arr))));
        	dfs(count+1,lookLeft(row,col,lookUp(row,col,lookDown(row,col,arr))));
        	dfs(count+1,lookRight(row,col,lookUp(row,col,lookDown(row,col,arr))));
        	dfs(count+1,lookDown(row,col,lookLeft(row,col,lookRight(row,col,arr))));
        	break;
        case 5:
        	dfs(count+1,lookUp(row,col,lookLeft(row,col,lookRight(row,col,lookDown(row,col,arr)))));
        	break;
        }
        
    }
    
    public static int[][] lookUp(int row, int col, int[][] arr) {
    	int[][] tmp = new int[N][M];
        for(int i=0; i<N; i++) {
        	tmp[i] = arr[i].clone();
        }
        int nr = row-1;
        while(nr>=0&&tmp[nr][col]!=6) {
            if(tmp[nr][col]==0) tmp[nr][col] = -1;
            nr = nr-1;
        }
        return tmp;
    }
    
    public static int[][] lookDown(int row, int col, int[][] arr) {
    	int[][] tmp = new int[N][M];
        for(int i=0; i<N; i++) {
        	tmp[i] = arr[i].clone();
        }
        int nr = row+1;
        while(nr<N&&tmp[nr][col]!=6) {
            if(tmp[nr][col]==0) tmp[nr][col] = -1;
            nr = nr+1;
        }
        return tmp;
    }
    
    public static int[][] lookLeft(int row, int col, int[][] arr) {
    	int[][] tmp = new int[N][M];
        for(int i=0; i<N; i++) {
        	tmp[i] = arr[i].clone();
        }
        int nc = col-1;
        while(nc>=0&&tmp[row][nc]!=6) {
            if(tmp[row][nc]==0) tmp[row][nc] = -1;
            nc = nc-1;
        }
        return tmp;
    }
    
    public static int[][] lookRight(int row, int col, int[][] arr) {
    	int[][] tmp = new int[N][M];
        for(int i=0; i<N; i++) {
        	tmp[i] = arr[i].clone();
        }
        int nc = col+1;
        while(nc<M&&tmp[row][nc]!=6) {
            if(tmp[row][nc]==0) tmp[row][nc] = -1;
            nc = nc+1;
        }
        return tmp;
    }
    
    // 사각지대의 수를 계산하는 함수
    public static int countInvisible(int[][] array) {
        int invisible = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(array[i][j]==0) invisible++; 
            }
        }
        
        return invisible;
    }
    
    

}
