import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable {
	int index;
	int cost;
	int oddEven;

	Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Object o) {
		return (int) (cost - ((Node) o).cost);
	}
}

public class Main {
	static int N, M;
	static int[] distFox;
	static int[][] distWolf;
	static int answer;
	static List<List<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = 0;
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Node>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, d * 2));
			graph.get(b).add(new Node(a, d * 2));

		}

		dijkstraFox();
		dijkstraWolf();

		for(int i=2; i<=N; i++) {
			if(distFox[i]<Math.min(distWolf[i][0], distWolf[i][1])) answer++;
		}

		System.out.println(answer);

	}

	private static void dijkstraFox() {
		distFox = new int[N + 1];
		Arrays.fill(distFox, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		distFox[1] = 0;
		pq.add(new Node(1, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (distFox[cur.index] < cur.cost)
				continue;

			for (Node next : graph.get(cur.index)) {
				if (distFox[next.index] > distFox[cur.index] + next.cost) {
					distFox[next.index] = distFox[cur.index] + next.cost;
					pq.add(new Node(next.index, distFox[next.index]));
				}
			}
		}

	}

	private static void dijkstraWolf() {
		distWolf = new int[N + 1][2];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(distWolf[i], Integer.MAX_VALUE);
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		distWolf[1][0] = 0;
		Node start = new Node(1, 0);
		start.oddEven = 0;
		pq.add(start);

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			boolean isOdd = false;

			// 홀수번째 방문할 경우
			if (cur.oddEven == 1) {

				if (distWolf[cur.index][1] < cur.cost)
					continue;

				// 다음번은 짝수다.
				for (Node next : graph.get(cur.index)) {
					if (distWolf[next.index][0] > distWolf[cur.index][1] + next.cost * 2) {
						distWolf[next.index][0] = distWolf[cur.index][1] + next.cost * 2;
						Node newNode = new Node(next.index, distWolf[next.index][0]);
						newNode.oddEven = 0;
						pq.add(newNode);
					}
				}
			}
			// 짝수번째 방문할 경우
			else {
				if (distWolf[cur.index][0] < cur.cost)
					continue;

				// 다음번은 홀수다.
				for (Node next : graph.get(cur.index)) {
					if (distWolf[next.index][1] > distWolf[cur.index][0] + next.cost / 2) {
						distWolf[next.index][1] = distWolf[cur.index][0] + next.cost / 2;
						Node newNode = new Node(next.index, distWolf[next.index][1]);
						newNode.oddEven = 1;
						pq.add(newNode);
					}
				}
			}

		}
	}

}