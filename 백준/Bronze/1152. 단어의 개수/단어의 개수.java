import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        
        String[] strArr = str.trim().split(" ");
        if(strArr[0]==""){
            System.out.print(0);
        } else {
            System.out.print(strArr.length);
        }
        
	}	
}
