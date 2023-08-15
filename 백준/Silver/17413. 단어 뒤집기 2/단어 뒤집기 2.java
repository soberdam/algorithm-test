import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder words = new StringBuilder();
		StringBuilder word = new StringBuilder();
		String S = br.readLine();
		for(int i=0; i<S.length(); i++) {
			char c = S.charAt(i);
			
			// 여는 꺽새가 나온다면 담아둔 단어를 뒤집어 저장하고 닫는 꺽새가 나올 때까지 그대로 저장
			if(c=='<') {
				word.reverse();
				words.append(word.toString());
				word.setLength(0);
				for(int j=i; j<S.length(); j++) {
					words.append(S.charAt(j));
					if(S.charAt(j)=='>') {
						i = j;
						break;
					}
				}
				continue;
			}
			
			if(c==' ') {
				// 단어가 들어오면 뒤집은 후 공백을 추가하여 words에 append
				word.reverse();
				word.append(c);
				words.append(word.toString());
				word.setLength(0);
				continue;
			}
			
			word.append(c);
		}
		//마지막 단어 뒤집은 후 추가
		word.reverse();
		words.append(word.toString());
		
		//출력
		bw.write(words.toString());
		bw.close();
		
	}

}

/* StringBuilder를 초기화 하는 방법
StringBuilder sb = new StringBuilder(); 라는 객체가 있다면,

sb.setLength(0); 으로 초기화 하는 것이 가장 빠르다.
*/