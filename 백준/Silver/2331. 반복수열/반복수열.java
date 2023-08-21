
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int A;
	static int P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		// 수를 저장할 어레이리스트 생성
		ArrayList<Integer> list = new ArrayList<>();
		list.add(A);
		int idx = 0;
		int breakpoint = 0;
		while(true) {
			String s = String.valueOf(list.get(idx++));
			int next = 0;
			for(int i=0; i<s.length(); i++) {
				int num = s.charAt(i) - '0';
				next+=(int)Math.pow(num, P);
			}
			
			if(list.contains(next)) {
				breakpoint = next;
				break;
			}
			else {
				list.add(next);
			}
		}
		
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)==breakpoint) {
				break;
			} else {
				count++;
			}
		}
		
		System.out.println(count);
	}

}