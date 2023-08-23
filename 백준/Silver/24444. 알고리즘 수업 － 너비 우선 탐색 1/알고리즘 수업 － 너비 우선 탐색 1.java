import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) + 1;// 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        int R = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list.get(vertex).add(child);
            list.get(child).add(vertex);
        }
        
        for (int i = 0; i < list.size(); i++) {
        	Collections.sort(list.get(i));
        }
        
        boolean[] visited = new boolean[N];
        Queue<Integer> que = new LinkedList<>();
        que.add(R);
        visited[R] = true;
        int seq = 1;
        int[] count = new int[N];
        count[R] = seq;
        while(!que.isEmpty()) {
            int fr = que.poll();
            for (int to : list.get(fr)) {
                if(!visited[to]) {
                    visited[to] = true;
                    count[to] = ++seq;
                    que.add(to);
                }
            }
        }
        
        for (int i = 1; i < N; i++) {
            System.out.println(count[i]);
        }
    } // main

}
