import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedArrayType;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  불이 붙은 위치에서 BFS를 하여 불이 도착하는 분(최단거리)을 새 배열(fire)에 저장
 *  지훈이의 위치에서 BFS를 하며, 지훈이가 도착하는 시간(최단거리)에 불이 없다면(fire의 값보다 작다면) 이동.
 *  이 이동한 최단거리를 새 배열(escape)에 저장
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[200001];
		for(int i=0; i<arr.length; i++) {
			arr[i] = -1;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		arr[N] = 0;
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			if(idx == K) {
				System.out.println(arr[idx]);
				return;
			}
			int[] dx = {idx-1, idx+1, idx*2};
			for(int d=0; d<3; d++) {
				int nx = dx[d];
				if(nx>=0&&nx<arr.length&&arr[nx]==-1) {
					arr[nx] = arr[idx]+1;
					queue.offer(nx);
				}
			}
		}
		
	}

}