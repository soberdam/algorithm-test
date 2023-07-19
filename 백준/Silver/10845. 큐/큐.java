import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int last = 0;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
			case ("push"):
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				last = num;
				break;
			case ("pop"):
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}
				break;
			case ("size"):
				System.out.println(queue.size());
				break;
			case ("empty"):
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case ("front"):
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
				}
				break;
			case ("back"):
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(last);
				}
				break;

			}

		}
	}

}