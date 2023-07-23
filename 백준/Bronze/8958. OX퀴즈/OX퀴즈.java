import java.io.*;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String [] arr = br.readLine().split("");
			int sum = 0;
			int cSum = 0;
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j].equals("O")) {
					cSum++;
					sum += cSum;
				} else {
					cSum = 0;
				}
			}
			System.out.println(sum);
		}
		
		
 	}
	

}

