
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Stack<Character> stack = new Stack<>();

	String str = br.readLine();
	int total = 0;
	int bar = 0; // 막대 개수
	for (int i = 0; i < str.length(); i++) {
	    char bracket = str.charAt(i);

	    // 여는 괄호일 때
	    if (bracket == '(') {
		bar++;
		total++;
		stack.push(bracket);
	    }
	    // 닫는 괄호일 때
	    else {
		// 레이져일때
		if (stack.peek() == '(') {
		    stack.push(bracket);
		    bar--;
		    total--;
		    total += bar;
		}
		// 바 끊길 때
		else {
		    stack.push(bracket);
		    bar--;
		}
	    }
	}
	System.out.println(total);

    }

}
