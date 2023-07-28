import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int start = 0;
		
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input>start) {
				for(int j=start+1; j<=input; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				start = input;
			} 
			
			if (stack.peek()==input){
				stack.pop();
				sb.append("-\n");
			} 
		}
		if(stack.isEmpty()) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	
	}
}
