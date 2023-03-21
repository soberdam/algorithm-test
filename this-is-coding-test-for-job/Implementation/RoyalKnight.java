/*
 * 8 * 8 좌표 평면상에서 나이트의 위치가 주어졌을 때, 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하세요.
 * 행 위치는 1부터 8, 열 위치는 a부터 h로 표현합니다.
 * 나이트는 특정 위치에서 2가지 경우로 이동할 수 있습니다.
 * 1. 수평으로 두 칸 이동 후에 수직으로 한 칸 이동하기
 * 2. 수직으로 두 칸 이동 후에 수평으로 한 칸 이동하기
 * 입력 조건 : 첫째 줄에 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다. 입력 문자는 a1처럼 열과 행으로 이루어진다.
 * 출력 조건 : 첫째 줄에 나이트가 이동할 수 있는 경우의 수를 출력하시오.
 */
package Implementation;
import java.util.*;
public class RoyalKnight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String knight = sc.next();
		//초기 위치값
		int row = knight.charAt(1) - '0';
		int column = knight.charAt(0) - 'a' + 1;
		int cnt = 0;
		// 나이트가 이동할 수 있는 8가지 방향 정의
		int [] dx = {-2, -2, 2, 2, 1, 1, -1, -1}; 
		int [] dy = {-1, 1, -1, 1,-2, 2, -2, 2};
		
		
		
		//나이트 이동
		for(int i=0; i<8; i++) {
			//이동하고자 하는 위치 확인
			int nextRow = row + dx[i];
			int nextCoulmn = column + dy[i];
				if (nextRow < 1 || nextRow > 8|| nextCoulmn < 1 || nextCoulmn > 8) {
					continue;
				}
				// 해당 위치로 이동이 가능하다면 카운트 증가
				cnt++;
				
			
		}
		
		System.out.println(cnt);
	}

}
