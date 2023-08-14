import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		int x = 0;
		int y = 0;
		int xOver = p + t;
		int yOver = q + t;
		int xRemain = xOver % w;
		int yRemain = yOver % h;
		// x축 방향을 홀수번 전환했다면 좌측으로 나머지 이동
		// x축 방향을 짝수번 전환했다면 우측으로 나머지 이동
		x = (xOver / w) % 2 == 1 ? w - xRemain : xRemain;
		
		// y축 방향을 홀수번 전환했다면 하단으로 나머지 이동
		// y축 방향을 짝수번 전환했다면 상단으로 나머지 이동
		y = (yOver / h) % 2 == 1 ? h - yRemain : yRemain;

		sb.append(x);
		sb.append(" ");
		sb.append(y);
		bw.write(sb.toString());
		bw.close();

	}
	
}
