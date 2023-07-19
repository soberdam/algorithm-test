import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int count = 0;
			Queue <int[]> printQueue = new LinkedList<>();
			for(int j=0; j<n; j++) {
				printQueue.add(new int[] {j,sc.nextInt()});
			}
			
			while(true) {
				int[] now = printQueue.poll();
				boolean switched = false;
				for(int q[] : printQueue) {
					if(q[1]>now[1]) {
						switched = true;
						break;
					}
				}
				if (!switched) {
					count++;
					if(now[0]==m) {
						break;
					}
				} else {
					printQueue.add(now);
				}
				
			}
			System.out.println(count);
		}
		
	}

}