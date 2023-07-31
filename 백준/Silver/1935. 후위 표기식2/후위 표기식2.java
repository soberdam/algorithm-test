import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] arr = new double[n];
		for (int i = 0; i < n; i++) {
			double num = Double.parseDouble(br.readLine());
			arr[i] = num;
		}

		Stack<Double> numbers = new Stack<>();
		double answer = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				numbers.push(arr[str.charAt(i) - 'A']);
			} else {
				if (!numbers.isEmpty()) {
					double a = numbers.pop();
					double b = numbers.pop();
					answer = a * b;
					switch (str.charAt(i)) {
					case '+':
						answer = b + a;
						numbers.push(answer);
						break;
					case '-':
						answer = b - a;
						numbers.push(answer);
						break;
					case '*':
						answer = b * a;
						numbers.push(answer);
						break;
					case '/':
						answer = b / a;
						numbers.push(answer);
						break;
					}
				}
			}

		}

		System.out.printf("%.2f", answer);
	}

}
