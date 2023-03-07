import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));    
        
        int cnt = Integer.parseInt(bf.readLine());
        String [] numArr = new String[cnt];
        numArr = bf.readLine().split(" ");
        int targetNum = Integer.parseInt(bf.readLine());
        int num = 0;
        
        for(int i=0; i<cnt; i++) {
            if(Integer.parseInt(numArr[i]) == targetNum) {
                num++; 
            }
        }     
        bw.write(String.valueOf(num));
        bw.flush();
    }
}