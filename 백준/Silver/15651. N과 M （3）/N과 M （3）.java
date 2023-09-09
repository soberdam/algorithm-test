import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;



public class Main {
    static int N;
    static int M;
    static StringBuilder sb;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0);
        bw.close();
       
    }
    public static void dfs(int count) throws IOException {
        if(count==M) {
        	bw.write(sb.toString());
        	return;
        }
    	for(int i=1; i<=N; i++) {
    		sb.append(String.valueOf(i)).append(' ');
    		dfs(count+1);
    		sb.delete(sb.length()-(String.valueOf(i).length()+1), sb.length());
    	}
    }
    

}
