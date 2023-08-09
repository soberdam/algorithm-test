import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	
	double count = 0;
	String str = br.readLine();
	for(int i=0; i<str.length(); i++) {
	    if(str.charAt(i)=='S') count += 1;
	    if(str.charAt(i)=='L') count += 0.5;
	}
	
	count += 1;
	
	int answer = Math.min(N,(int)count);
	
	System.out.println(answer);

    }

}
