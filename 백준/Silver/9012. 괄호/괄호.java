import java.util.Stack;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			Stack<String> stack = new Stack<>();
			boolean isVPS = true;
			String[] ps = br.readLine().split("");
			for(String p : ps) {
				if(p.equals("(")) {
					stack.push(p);
				} else if(p.equals(")")) {
					if(stack.empty()) {
						isVPS = false;
						break;
					} else {
						stack.pop();
					}
				}
				
			}
			if(!stack.empty()) {
				isVPS = false;
			}
			
			if(isVPS) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		
	}

}