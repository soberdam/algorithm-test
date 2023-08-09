
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String str = br.readLine();
	StringBuilder sb = new StringBuilder();
	int n = str.length();
	int r = 0;
	int c = 0;
	for (int i = 1; i <= Math.sqrt(n); i++) {
	    if (n % i == 0) {
		r = i;
		c = n / i;
	    }
	}
	char[][] arr = new char[r][c];
	int s = 0;
	
	for(int j=0; j<c; j++) {
	    for(int i=0; i<r; i++) {
		arr[i][j] = str.charAt(s++);
	    }
	}
	
	
	for (int i = 0; i < r; i++) {
	    for (int j = 0; j < c; j++) {
		sb.append(arr[i][j]);
	    }
	}
	
	
	
	System.out.println(sb.toString());

    }

}
