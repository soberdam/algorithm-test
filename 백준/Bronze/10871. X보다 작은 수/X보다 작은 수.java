import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String [] nAndx = new String[2];
        nAndx = bufferedreader.readLine().split(" ");
        int n = Integer.parseInt(nAndx[0]);
        int x = Integer.parseInt(nAndx[1]);
        
        String [] numbers = new String[n];
        numbers = bufferedreader.readLine().split(" ");
        
        String lessThanX = "";
        for(int i=0; i<n; i++) {
            if(Integer.parseInt(numbers[i])<x) {
                lessThanX += (numbers[i] + " ");
            }
        }
        
        bufferedwriter.write(lessThanX);
        bufferedwriter.flush();
    }
}

