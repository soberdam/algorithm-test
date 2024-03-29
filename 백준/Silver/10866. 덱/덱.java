import java.util.Deque;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String order = st.nextToken();
			int num = 0;
			switch (order) {
			case ("push_front"): {
				num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
				break;
			}
			case ("push_back"): {
				num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
				break;
			}
			case ("pop_front"): {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.pollFirst());
				}

				break;
			}
			case ("pop_back"): {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.pollLast());
				}
				break;
			}
			case ("size"): {
				System.out.println(deque.size());
				break;
			}
			case ("empty"): {
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			}
			case ("front"): {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekFirst());
				}
				break;
			}
			case ("back"): {
				if (deque.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(deque.peekLast());
				}
				break;
			}
			}

		}

	}

}
