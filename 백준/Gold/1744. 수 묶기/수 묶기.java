import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> mList = new ArrayList<Integer>();
		ArrayList<Integer> pList = new ArrayList<Integer>();
		boolean isZero = false;
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num<0) {
				mList.add(num);
			} else if(num>1) {
				pList.add(num);
			} else if(num==0){
				isZero = true;
			} else {
				sum+=num;
			}
			
		}
		Collections.sort(mList);
		while(mList.size()>1) {
			int first = mList.remove(0);
			int second = mList.remove(0);
			sum+= first*second;
		}
		if(!isZero && !mList.isEmpty()) {
			sum+=mList.get(0);
		}
		
		Collections.sort(pList, Collections.reverseOrder());
		while(pList.size()>1) {
			int first = pList.remove(0);
			int second = pList.remove(0);
			sum+= first*second;
		}
		if(!pList.isEmpty()) {
			sum+=pList.get(0);
		}
		
		System.out.println(sum);
	}
	
}
