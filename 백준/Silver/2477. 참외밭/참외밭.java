import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 참외의 개수
		int[] lens = new int [6];
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); // 변의 방향
			int len = Integer.parseInt(st.nextToken()); // 변의 길이
			
			lens[i] = len;
			
		}
		int maxW = Integer.MIN_VALUE;
		int maxH = Integer.MIN_VALUE;
		int maxWIdx = 0;
		int maxHIdx = 0;
		for(int i=0; i<6; i++) {
			// 가로 세로 최대길이 찾기, 인덱스 저장
			if(i%2==0) {
				if(lens[i]>maxW) {
					maxW = lens[i];
					maxWIdx = i;
				}
			} else {
				if(lens[i]>maxH) {
					maxH = lens[i];
					maxHIdx = i;
				}
			}
		}
		// 가장 긴 가로/세로의 옆에 붙은 두개의 세로/가로 길이의 차가 작은 사각형의 세로/가로
		int minW = Math.abs(lens[((maxWIdx-1)+6)%6]-lens[(maxWIdx+1)%6]);
		int minH = Math.abs(lens[((maxHIdx-1)+6)%6]-lens[(maxHIdx+1)%6]);
		
		int area = (maxW*maxH) - (minW*minH);
		System.out.println(area*K);
	}

}
