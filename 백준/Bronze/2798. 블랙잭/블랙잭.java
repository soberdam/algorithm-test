import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());

		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = 0;
		int target = m;
		int[] arr = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}

		for (int a = 0; a < n; a++) {
			for (int b = a + 1; b < n; b++) {
				for (int c = b + 1; c < n; c++) {
					sum = arr[a] + arr[b] + arr[c];
					if (target - sum < min && target - sum >= 0) {
						min = target-sum;
						max = sum;
					}
				}
			}

		}

		bw.write(""+max);
		bw.close();

	}

}
