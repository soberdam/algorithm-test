import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int countOfNum = Integer.parseInt(bufferedreader.readLine());
        String [] strArr = new String [countOfNum];
        strArr = bufferedreader.readLine().split(" ");
        int max = Integer.parseInt(strArr[0]);
        int min = Integer.parseInt(strArr[0]);
        for (int i=1; i<countOfNum; i++) {
            if(Integer.parseInt(strArr[i]) > max) {
                max = Integer.parseInt(strArr[i]);
            } else if (Integer.parseInt(strArr[i]) < min){
                min = Integer.parseInt(strArr[i]);
            }
        }
        bufferedwriter.write(String.valueOf(min)+" "+String.valueOf(max));
        bufferedwriter.flush();
    }
}