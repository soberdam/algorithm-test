package Implementation;

import java.util.*;
/*
 * 여행가 A는 N*N 크기의 정사각형 공간 위에 서있습니다. 이 공간은 1x1 크기의 정사각형으로 나누어져 있습니다.
 * 가장 왼쪽 위 좌표는 (1,1)이며 가장 오른쪽 아래 좌표는 (N,N)에 해당합니다.
 * 여행가 A는 상,하,좌,우 방향으로 이동할 수 있으며 시작 좌표는 항상 (1,1)입니다.
 * 계획서에는 공백을 기준으로 L,R,U,D중 하나의 문자가 반복적으로 적혀져 있습니다.
 * L은 왼쪽으로, R은 오른쪽으로, U는 위로, D는 아래로 한 칸 이동합니다.
 * 이 때 여행가 A가 N*N 크기의 정사각형 공간을 벗어나는 움직임은 무시됩니다.
 * 입력 조건 : 첫째 줄에 공간의 크기를 나타내는 N이 주어집니다. (1<=N<=100)
 * 입력 조건 : 둘째 줄에 여행가 A가 이동할 계획서 내용이 주어집니다. (1<=이동 횟수<=100)
 * 출력 조건 : 첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌쵸를 공백을 기준으로 구분하여 출력합니다.
 */
public class UpDownLeftRight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = 1, y = 1;
		//L, R, U, D에 따른 이동 방향
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		String [] moveTypes = {"L", "R", "U", "D"};
		
		sc.nextLine(); // 버퍼 비우기
		String strLine = sc.nextLine();
		String [] plans = strLine.split(" ");
		// 이동 계획을 하나씩 확인하기
		for(int i=0; i<plans.length; i++) {
			String plan = plans[i];
			int nx = 0, ny = 0;
			for(int j=0; j<4; j++) {
				if(plan.equals(moveTypes[j])) {
					nx = x + dx[j];
					ny = x + dy[j];
				}
			}
			// 공간을 벗어나는 경우 이동 무시
			if(nx<1 || ny <1 || nx>n || ny>n)
				continue;
			// 이동 수행
			x = nx;
			y = ny;
			
		}
		
		System.out.println(x + " " + y);
	}

}
