import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] answer = new char[4];
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());

			// if 공통 부분이 없는 경우
			if (p2 < x1 || x2 > p1 || q2 < y1 || y2 > q1) {
				System.out.println("d");
				continue;
			}

			// if 공통 부분이 점인 경우
			if ((p2 == x1 && q2 == y1) || (p2 == x1 && y2 == q1) || (x2 == p1 && q2 == y1) || (x2 == p1 && y2 == q1)) {
				System.out.println("c");
				continue;
			}

			// if 공통 부분이 선분인 경우
			if(p2==x1 || x2==p1 || q2==y1 || q1 == y2) {
				System.out.println("b");
				continue;
			}
			
			
			// if 공통부분이 직사각형인 경우
			System.out.println("a");
			continue;

		}

		
	}

}
