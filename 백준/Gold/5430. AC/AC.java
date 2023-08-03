
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/*
 * new 생성자가 아닌  Array.asList 로 생성한 리스트는 고정되어 있어 원소를 제거 할 수 없다
 */

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<String> deque;
		List<String> list;
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			String order = br.readLine();
			int arrLen = Integer.parseInt(br.readLine());
			String arrStr = br.readLine();

			
			//stream으로 명령문에 있는 D의 개수를 센 다음, 배열의 길이보다 많다면 error
			int dNum = (int)order.chars().filter(c->c=='D').count();
			if(dNum>arrLen) {
				System.out.println("error");
				continue;
			}
			
			//리스트에 저장
			String[] numbers = arrStr.replace("[","").replace("]", "").split(",");
			deque = new ArrayDeque<String>(Arrays.asList(numbers));
			
			
			//순서대로 명령 수행, 앞뒤로 빼기 위해 덱에 저장
			int rCount = 0;
			for(int j=0; j<order.length(); j++) {
				if(order.charAt(j)=='R') {
					rCount++;
				} else if (order.charAt(j)=='D'){
					if(rCount%2==0) {
						deque.removeFirst();
					} else {
						deque.removeLast();
					}
				}
			}
			
			// 덱을 다시 리스트로 만들고 R이 홀수라면 뒤집기
			
			list = new ArrayList<String>(deque);
			if (rCount%2==1) {
				Collections.reverse(list);
			}
			
			//배열로 반환
			String[] res = new String[list.size()];
			list.toArray(res);
			System.out.println(Arrays.toString(res).replace(" ",""));
			
		}
		

	}

}
