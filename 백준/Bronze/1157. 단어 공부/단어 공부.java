import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
    private static final char A = 0;

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        str = str.toUpperCase();
        int [] alphabetCount = new int[26];
        char [] alphabets = new char[26];
        for(int i=0; i<26; i++){
            alphabets[i] = (char)(i+65);
        }
        
        for(int i=0; i<str.length(); i++){
            for(char j='A'; j<='Z'; j++){
                if(str.charAt(i)==j){
                	alphabetCount[(int)(j-65)]++;
                	break;
                }
            }
        }
        
        int max = 0;
        char maxAlphabet = 'A';
        for(int i=0; i<26; i++) {
            if (alphabetCount[i]>max) {
                max = alphabetCount[i];
                maxAlphabet = alphabets[i];
            }
        }
        
        boolean isOverlap = false;
        for(int i=0; i<26; i++){
            if (alphabetCount[i] == max && alphabets[i] != maxAlphabet) {
                System.out.print("?");
                isOverlap = true;
                break;
            }
        }
        if(isOverlap == false) {
            System.out.print(maxAlphabet);
        }
    }
}