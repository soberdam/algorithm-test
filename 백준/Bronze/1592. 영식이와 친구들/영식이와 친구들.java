import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	int L = Integer.parseInt(st.nextToken());
	
	int[] arr = new int[N];
	arr[0]++;
	
	int ball = 0;
	int count = 0;
	while(true) {
	    
	    if(arr[ball]==M) break;
	    
	    //홀수일 때 시계방향 L번째
	    if(arr[ball]%2==1) {
		ball = (ball+L)%N;
		arr[ball]++;
		count++;
	    } 
	    //짝수일 때 반시계 L번째
	    else {
		ball = ball-L<0 ? ball-L+N : ball-L;
		arr[ball]++;
		count++;
	    }
	    
	}
	
	System.out.println(count);
	
    }
    
 
   

    

}
