import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		int index = m-1;
		ArrayList<Integer> aList = new ArrayList<>();
		for(int j=1; j<=n; j++) {
			aList.add(j);
		}
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			if(index>aList.size()-1) {
				index = index%aList.size();
			}
			arr[i] = aList.remove(index);
			index+=m-1;
		}
		System.out.print("<");
		for(int num : arr) {
			if(num == arr[0]) {
				System.out.print(num);
			} else {
				System.out.print(", "+ num);
			}
		}
		System.out.print(">");
	}

}
