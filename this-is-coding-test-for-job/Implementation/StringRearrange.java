package Implementation;
import java.util.*;
public class StringRearrange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int total = 0;
		ArrayList<Character> chList = new ArrayList<Character>();
		
		// 문자를 하나씩 확인하며
		for(int i=0; i<s.length(); i++) {
			// 알파벳인 경우 결과를 리스트에 삽입
			if(Character.isLetter(s.charAt(i))) {
				chList.add(s.charAt(i));
			} 
			// 숫자는 따로 더하기
			else {
				total += s.charAt(i)-'0';
			}
		}
		
		// 알파벳 오름차순 정렬
		Collections.sort(chList);
		
		for(char c : chList) {
			System.out.print(c);
		}
		// 숫자가 하나라도 존재하는 경우 가장 뒤에 출력
		if (total != 0) System.out.print(total);
		
	}

}
