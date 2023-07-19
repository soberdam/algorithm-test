import java.util.Queue;
import java.util.LinkedList;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int num = queue.peek();

		for (int j = 0; j < N - 1; j++) {
			queue.remove();
			if (!queue.isEmpty()) {
				num = queue.poll();
				queue.add(num);
			}
		}

		System.out.println(num);

	}

}
