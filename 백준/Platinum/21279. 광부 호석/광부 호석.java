
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Mineral implements Comparable {
	int x;
	int y;
	int v;

	Mineral(int x, int y, int v) {
		this.y = y;
		this.v = v;
	}

	@Override
	public int compareTo(Object o) {
		Mineral m = (Mineral)o;
		return this.y - m.y;
	}
	
	
}

public class Main {
	static int N, C;
	static long maxSum = 0;
	static long tempSum = 0;
	static int tempCount = 0;
	static List<List<Mineral>> mine = new ArrayList<>();
	static List<List<Mineral>> mineY = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 100001; i++) {
			mine.add(new ArrayList<Mineral>());
			mineY.add(new ArrayList<Mineral>());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			mine.get(X).add(new Mineral(X, Y, V));
			mineY.get(Y).add(new Mineral(X, Y, V));
		}
		for (int i = 0; i < 100001; i++) {
			Collections.sort(mine.get(i));
			Collections.sort(mineY.get(i), (o1, o2)-> {
				return (o1.x - o2.x);
			});
		}
		int end = 100000;

		for (int start = 0; start < 100001; start++) {
			for (int i = 0; i < mine.get(start).size(); i++) {
				if (mine.get(start).get(i).y <= end) {
					tempSum += mine.get(start).get(i).v;
					tempCount++;
				} else {
					break;
				}
			}
			while (tempCount >+ C) {
				for (int i = 0; i <mineY.get(end).size(); i++) {
					if (mineY.get(end).get(i).x <= start) {
						tempSum -= mineY.get(end).get(i).v;
						tempCount--;
					} else {
						break;
					}
				}
				end--;
			}
			maxSum = Math.max(maxSum, tempSum);
		}
		
		System.out.println(maxSum);
	}

}
