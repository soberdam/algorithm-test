
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 우선순위 큐에 비교조건을 람다식으로 삽입
		PriorityQueue<Integer> pQueue = new PriorityQueue<>((a,b)-> {
			if(Math.abs(a)==Math.abs(b)) {
				return a-b;
			} else {
				return Math.abs(a) - Math.abs(b);
			}
		});
		
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			//0이 아니면 우선순위 큐에 추가
			if(input!=0) {
				pQueue.add(input);
			}
			//0이면 출력후 제거
			else {
				// 배열이 비어있는 경우 0 출력
				if(pQueue.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pQueue.poll());
				}
			}
		}

			
			
		

	}

}
