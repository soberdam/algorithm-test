/*
 * 한 마을에 모험가가 N명 있다. 공포도가 X인 모험가는 반드시 X명 이상으로 구성한 모험가 그룹에 참여해야 여행을 떠날 수 있다.
 * 이때 N명의 모험가에 대한 공포도 정보가 주어졌을 때, 여행을 떠날 수 있는 그룹 수의 최댓값을 구하는 프로그램을 작성하시오.
 * 모험가의 일부는 마을에 남아있어도 되기 때문에, 모든 모험가를 특정한 그룹에 넣을 필요는 없다
 * 입력 조건 : 첫째 줄에 모험가의 수 N이 주어집니다. (1 <= N <= 100,000)
 * 출력 조건 : 여행을 떠날 수 있는 그룹 수의 최댓값을 출력합니다.
 */

package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdventurerGuild {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int groupMax = 0;
		int count = 0;
		ArrayList<Integer> advList = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			advList.add(scanner.nextInt());
		}
		Collections.sort(advList); // 공포도를 오름차순 정렬
		
		for(int a : advList) {
			count += 1;
			if(count>=a) { // 그룹에 참가한 인원이 필요 그룹 인원보다 같거나 크다면. 필요 그룹 인원을 충족한다면.
				groupMax++; // 그룹 수 1 증가 
				count = 0;
				continue;
			}
			
		}
		System.out.println(groupMax);
		
	}

}
