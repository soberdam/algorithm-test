import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
			case ("push"):
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case ("pop"):
				if (stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				break;
			case ("size"):
				System.out.println(stack.size());
				break;
			case ("empty"):
				if (stack.empty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case ("top"):
				if (stack.empty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				break;

			}
		}
	}

}