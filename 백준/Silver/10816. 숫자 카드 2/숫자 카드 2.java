import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> myCards = new HashMap();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(myCards.containsKey(num)) {
				myCards.put(num, myCards.get(num) + 1);
			} else {
				myCards.put(num, 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<m; j++) {
			int num = Integer.parseInt(st.nextToken());
			if(myCards.containsKey(num)) {
				bw.write(myCards.get(num)+ " ");
			} else {
				bw.write(0 + " ");
			}
		}
		bw.flush();
		bw.close();
		
//		시간 초과시
//		1. 쓸데없는 반복문 줄이기
//		2. 입력,출력이 많을 때는 br,bw 사용하기
		
		
 	}

}
