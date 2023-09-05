import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static StringBuilder sb = new StringBuilder();// sout하면 시간초과나서..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int cut = (int)Math.round(N*0.15);
        for(int i=0; i<cut; i++) {
        	arr[i] = 0;
        	arr[N-1-i] = 0;
        }
        int sum = 0;
        for(int i=0; i<N; i++) {
        	if(arr[i]!=0) sum+=arr[i];
        }
        int avg = (int)Math.round(sum/(double)(N-(cut+cut)));
        
        System.out.println(avg);
    }

}