
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static long find=0;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 내 위치
        K = Integer.parseInt(st.nextToken());// 동생 위치

        arr = new int[100001];// 수빈이와 동생이 있는 길.(0<=N,K<=100000)
        Arrays.fill(arr, Integer.MAX_VALUE);

        bfs(N, 0);
        
        for(int i=0; i<100001; i++) {
            if( i == K)
                System.out.println(arr[i]);
        }
        if(N == K) {
            System.out.println(1);
        }
        else
            System.out.println(find);
            

    }

    public static void bfs(int node, int depth) {
        
        arr[node] = depth++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            // x-1
            if (x - 1 >= 0) {
                if(arr[x-1]>=arr[x]+1) {
                    arr[x-1] = arr[x]+1;
                    queue.add(x - 1);
                    if(x-1 == K)
                        find++;
                }
            }
            // x+1
            if (x + 1 <= 100000) {
                if(arr[x+1]>=arr[x]+1) {
                    arr[x+1] = arr[x]+1;
                    queue.add(x+1);
                    if(x+1 == K)
                        find++;
                }
            }
            // 2*x
            if (x * 2 <= 100000) {
                if(arr[x*2] >= arr[x]+1) {
                    arr[x*2] = arr[x]+1;
                    queue.add(x*2);
                    if(x*2 == K)
                        find++;
                }
                
            }

        }

    }
}