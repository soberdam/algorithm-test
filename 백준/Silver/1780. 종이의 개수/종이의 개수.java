import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전체 크기 한장이 안되었을때 9분할
// 9분할 시에 각각의 종이에 대해 재귀해서 카운트해야 함(따로 카운트)
// 재귀에서 반복할 크기인 n, 시작하는 지점인 sr과 sc를 구한 이후에 해당지점부터 시작한다.
public class Main {
    static int minusCnt = 0;
    static int zeroCnt = 0;
    static int plusCnt = 0;

    static int[][] paper;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int N = Integer.parseInt(br.readLine());
        paper = new int [N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        countPaper(N, 0, 0);


        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.println(plusCnt);
    }

    public static void countPaper(int n, int sr, int sc) {
        int start = paper[sr][sc];
//        if(n==1) {
//            for(int i=sr; i<sr+3; i++) {
//                for(int j=sc; j<sc+3; j++) {
//                    if(paper[i][j] == -1) {
//                        minusCnt++;
//                    }
//                    if(paper[i][j] == 0) {
//                        zeroCnt++;
//
//                    }
//                    if(paper[i][j] == 1) {
//                        plusCnt++;
//                    }
//
//                }
//            }
//            return;
//        }
//        System.out.println((sr) + ", " + (sc) + " 에서 시작");
        for(int i=sr; i<sr+n; i++) {
            for(int j=sc; j<sc+n; j++) {
                // 숫자가 같지 않다면 현재 종이를 9등분
                if(paper[i][j] != start && !visited[i][j]) {
//                    System.out.println(i + ", " + j + " 에서 자르기");
                    for(int k=0; k<3; k++) {
                        for(int l=0; l<3; l++) {
                            countPaper(n/3, sr+k*n/3, sc+l*n/3);
                        }
                    }
                    return;
                }
                visited[i][j]=true;
            }
        }
        if(start == -1) {
            minusCnt++;
        }
        if(start == 0) {
            zeroCnt++;

        }
        if(start == 1) {
            plusCnt++;
        }

    }
}