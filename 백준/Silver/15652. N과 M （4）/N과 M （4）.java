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
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        answer = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dfs(0, 1);
        System.out.println(answer);
       
    }
    public static void dfs(int count, int idx){
        if(count==M) {
        	answer.append(sb.toString());
        	answer.append('\n');
        	return;
        }
    	for(int i=idx; i<=N; i++) {
    		sb.append(String.valueOf(i)).append(' ');
    		dfs(count+1, i);
    		sb.delete(sb.length()-(String.valueOf(i).length()+1), sb.length());
    	}
    }
    

}
