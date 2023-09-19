import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/*
 * 1. DFS로 간선을 3번 이동한 경우를 백트래킹한다.
 * 2. (depth가 0일 때)첫 시작 정점의 방문을 true로 하고, true인 정점은 다시 방문하지 않는다. 
 * 3. 2번 이동했을 때 돌아올 수 있는지 확인하고, 가능하면 삼각형의 개수를 count++한다.
 */

public class Solution {
	static int N;
	static int K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			Deque<Character> deque = new ArrayDeque<>();
			
			String numbers = br.readLine();
			for(int i=0; i<N; i++) {
				deque.add(numbers.charAt(i));
			}
			
			int line = numbers.length()/4;
			
			HashSet<String> set = new HashSet<>();
			for(int i=0; i<line; i++) {
				Iterator<Character> iter = deque.iterator();
				for(int j=0; j<numbers.length(); ) {
					StringBuilder sb = new StringBuilder();
					for(int k=0; k<line; k++) {
						char c = iter.next();
						sb.append(c);
						j++;
					}
					set.add(sb.toString());
				}
				// 회전
				deque.offerFirst(deque.pollLast());
				
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			Iterator<String> iter = set.iterator();
			while(iter.hasNext()) {
				String str = iter.next();
				int num = Integer.parseInt(str, 16);
				list.add(num);
			}
			Collections.sort(list, Collections.reverseOrder());
			int answer = list.get(K-1);
			System.out.printf("#%d %d\n", tc, answer);
		}

	}

	
		
	

}
