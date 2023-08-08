
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[] arr = new int[10];
	for (int i = 0; i < 10; i++) {
	    arr[i] = Integer.parseInt(br.readLine());
	}
	
	int[] sumArr = new int[10];
	int answer = 0;
	int sum = 0;
	
	for(int i=0; i<10; i++) {
	    sum += arr[i];
	    sumArr[i] = sum;
	}
	
	for(int i=0; i<10; i++) {
	    if(Math.abs(100-sumArr[i])<Math.abs(100-answer)) {
		answer = sumArr[i];
	    } else if(Math.abs(100-sumArr[i]) == Math.abs(100-answer)) {
		answer = Math.max(answer, sumArr[i]);
	    }
	}
	

	System.out.println(answer);
    }

}
