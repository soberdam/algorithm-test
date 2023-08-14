import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarfs = new int[9];
		int[] answer = new int[7];
		for (int i = 0; i < 9; i++) {
			int dwarf = Integer.parseInt(br.readLine());
			dwarfs[i] = dwarf;
		}
		Loop1: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				int sum = 0;
				for (int k = 0; k < 9; k++) {
					if (k != i && k != j) {
						sum += dwarfs[k];
					}
				}
				if (sum == 100) {
					int idx = 0;
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							answer[idx++] = dwarfs[k];
						}
					}
					break Loop1;
				}
			}
		}
		
		Arrays.sort(answer);
		
		for (int n : answer) {
			System.out.println(n);
		}
	}
}
