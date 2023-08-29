
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];
			int tankR = 0;
			int tankC = 0;
			for(int i=0; i<H; i++) {
				String s = sc.next();
				for(int j=0; j<W; j++) {
					map[i][j] = s.charAt(j);
					if(s.charAt(j)=='^'||s.charAt(j)=='v'||s.charAt(j)=='<'||s.charAt(j)=='>') {
						tankR = i;
						tankC = j;
					}
				}
			}
			int N = sc.nextInt();
			String str = sc.next();
			for(int i=0; i<str.length(); i++) {
				char order = str.charAt(i);
				switch(order) {
				case 'U':
					map[tankR][tankC] = '^';
					if(tankR-1>=0&&map[tankR-1][tankC]=='.') {
						map[tankR-1][tankC] = '^';
						map[tankR][tankC] = '.';
						tankR--;
					}
					break;
				case 'D':
					map[tankR][tankC] = 'v';
					if(tankR+1<H&&map[tankR+1][tankC]=='.') {
						map[tankR+1][tankC] = 'v';
						map[tankR][tankC] = '.';
						tankR++;
					}
					break;
				case 'L':
					map[tankR][tankC] = '<';
					if(tankC-1>=0&&map[tankR][tankC-1]=='.') {
						map[tankR][tankC-1] = '<';
						map[tankR][tankC] = '.';
						tankC--;
					}
					break;
				case 'R':
					map[tankR][tankC] = '>';
					if(tankC+1<W&&map[tankR][tankC+1]=='.') {
						map[tankR][tankC+1] = '>';
						map[tankR][tankC] = '.';
						tankC++;
					}
					break;
				case 'S':
					int nr = tankR;
					int nc = tankC;
					switch(map[tankR][tankC]) {
					case '^':
						while(true) {
							nr--;
							if(nr<0) break;
							
							if(map[nr][nc]=='*') {
								map[nr][nc] = '.';
								break;
							}
							
							if(map[nr][nc]=='#') {
								break;
							}
						}
						break;
					case 'v':
						while(true) {
							nr++;
							if(nr>=H) break;
							
							if(map[nr][nc]=='*') {
								map[nr][nc] = '.';
								break;
							}
							
							if(map[nr][nc]=='#') {
								break;
							}
						}
						break;
					case '<':
						while(true) {
							nc--;
							if(nc<0) break;
							
							if(map[nr][nc]=='*') {
								map[nr][nc] = '.';
								break;
							}
							
							if(map[nr][nc]=='#') {
								break;
							}
						}
						break;
					case '>':
						while(true) {
							nc++;
							if(nc>=W) break;
							
							if(map[nr][nc]=='*') {
								map[nr][nc] = '.';
								break;
							}
							
							if(map[nr][nc]=='#') {
								break;
							}
						}
						break;
						
					}
					break;
				}
			}
			System.out.printf("#%d ", test_case);
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}