import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T;
    static int[][] map;
    static int[][] countmap;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        countmap = new int[N][M];
        visit = new boolean[N][M];
        Point swd = new Point(0, 0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    swd.x = i;
                    swd.y = j;
                }
            }
        }
        int min =0;
        int swdcount = 0;
        go();

        if (!visit[swd.x][swd.y]) {
            if (visit[N-1][M-1] && countmap[N-1][M-1] <= T) {
                System.out.println(countmap[N-1][M-1]);
            } else {
                System.out.println("Fail");
            }
        } else {
            swdcount = countmap[swd.x][swd.y] + (N - 1 - swd.x) + (M - 1 - swd.y);

            if(visit[N-1][M-1]){
                min = Math.min(swdcount,countmap[N-1][M-1]);
                if(min<=T) System.out.println(min);
                else System.out.println("Fail");
            }else if(!visit[N-1][M-1]){
                if(swdcount<=T) System.out.println(swdcount);
                else System.out.println("Fail");
            }
        }

    }

    private static void go() {
        Queue<Point> qu = new LinkedList<>();
        qu.add(new Point(0, 0));
        visit[0][0] = true;
        while (!qu.isEmpty()) {
            Point now = qu.poll();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dr[i];
                int ny = y + dc[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] || map[nx][ny] == 1)
                    continue;
                visit[nx][ny] = true;
                countmap[nx][ny] = countmap[x][y] + 1;
                qu.add(new Point(nx, ny));
            }
        }
    }
}