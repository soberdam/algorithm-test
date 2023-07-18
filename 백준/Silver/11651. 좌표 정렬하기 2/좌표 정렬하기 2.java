import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] xy = new int[n][2];

		for (int i = 0; i < n; i++) {
			xy[i][0] = sc.nextInt();
			xy[i][1] = sc.nextInt();
		}

		Arrays.sort(xy, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else
				return o1[1] - o2[1];
		});
		
		for(int[] arr : xy) {
			System.out.println(arr[0] + " " + arr[1]);
		}
	}

}