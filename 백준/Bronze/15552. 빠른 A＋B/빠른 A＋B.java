import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        String numStr = "";
        for (int i=1; i<=testNum; i++) {
            numStr = br.readLine();
            a = Integer.parseInt(numStr.split(" ")[0]); 
            b = Integer.parseInt(numStr.split(" ")[1]);
            bw.write((a+b)+"\n");
            
        }       
        bw.flush();
    }
}