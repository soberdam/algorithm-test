import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] words = new String [n];
		for(int i=0; i<n; i++) {
			words[i]=br.readLine();
		}
		//중복 제거
		String[] distinctWords = Arrays.stream(words).distinct().toArray(String[]::new); 
		
		
		Arrays.sort(distinctWords, (o1, o2) -> {
			if (o1.length()==o2.length()) {
				//사전 순 정렬
				return o1.compareTo(o2);
			} else {
			//길이 순 정렬
			return o1.length() - o2.length();
			}
		});
		
		
		
		
		for(int j=0; j<distinctWords.length; j++) {
			System.out.println(distinctWords[j]);
		}
	}

}
