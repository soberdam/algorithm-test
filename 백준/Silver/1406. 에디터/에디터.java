import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		LinkedList<Character> editor = new LinkedList<>();
		for(int i=0; i<str.length(); i++) {
			editor.add(i, str.charAt(i));
		}
		ListIterator<Character> cursor = editor.listIterator(editor.size());
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			char order = s.charAt(0);
			switch(order) {
			case'L':
				if(cursor.hasPrevious()) cursor.previous();
				break;
			case'D':
				if(cursor.hasNext()) cursor.next();
				break;
			case'B':
				if(cursor.hasPrevious()) {
					cursor.previous();
					cursor.remove();
				}
				break;
			case'P':
				cursor.add(s.charAt(2));
				break;
			}
		}
		for(char c : editor) {
			bw.write(c);
		}
		bw.flush();
		bw.close();
	}
}
