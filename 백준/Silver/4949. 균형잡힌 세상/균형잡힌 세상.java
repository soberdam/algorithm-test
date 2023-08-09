
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Stack<Character> stack;
	while(true) {
	    String str = br.readLine();
	    if(str.equals(".")) break;
	    
	    boolean isRight = true;
	    stack = new Stack<>();
	    
	    for(int i=0; i<str.length(); i++) {
		if(str.charAt(i)=='.') break;
		
		if(str.charAt(i)=='(' || str.charAt(i)=='[') {
		    stack.push(str.charAt(i));
		} 
		else if(str.charAt(i)==')' || str.charAt(i)==']') {
		    if(stack.isEmpty()) {
			isRight = false;
			break;
		    } else {
			char c = stack.pop();
			if(str.charAt(i)==')' && c == '(') {
			    isRight = true;
			} else if (str.charAt(i)==']' && c == '[') {
			    isRight = true;
			} else {
			    isRight = false;
			    break;
			}
		    }
		}
	    }
	    
	    if(!stack.isEmpty()) {
		isRight = false;
	    }
	    
	    if(isRight) {
		System.out.println("yes");
	    } else {
		System.out.println("no");
	    }
	}

    }

}
