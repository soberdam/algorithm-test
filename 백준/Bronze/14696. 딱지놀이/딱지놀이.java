
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 라운드 수
		StringTokenizer st;
		int[] aCards; 
		int[] bCards; 
		
		for(int i=0; i<n; i++) {
			aCards = new int [5];
			bCards = new int [5];
			st = new StringTokenizer(br.readLine());
			int aCount = Integer.parseInt(st.nextToken());
			for(int j=0; j<aCount; j++) {
				int aNum = Integer.parseInt(st.nextToken());
				aCards[aNum]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int bCount = Integer.parseInt(st.nextToken());
			for(int j=0; j<bCount; j++) {
				int bNum = Integer.parseInt(st.nextToken());
				bCards[bNum]++;
			}
			
			if(aCards[4]>bCards[4]) {
				System.out.println("A");
			} else if (bCards[4]>aCards[4]) {
				System.out.println("B");
			} else {
				if(aCards[3]>bCards[3]) {
					System.out.println("A");
				} else if (bCards[3]>aCards[3]) {
					System.out.println("B");
				} else {
					if(aCards[2]>bCards[2]) {
						System.out.println("A");
					} else if (bCards[2]>aCards[2]) {
						System.out.println("B");
					} else {
						if(aCards[1]>bCards[1]) {
							System.out.println("A");
						} else if (bCards[1]>aCards[1]) {
							System.out.println("B");
						} else {
							System.out.println("D");
						}
					}
				}
			}
		}
		
		
		
		
		
		
	}
	
	
		

}
