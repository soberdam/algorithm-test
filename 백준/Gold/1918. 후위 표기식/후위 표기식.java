
import java.util.Scanner;
import java.util.Stack;

class Main {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		StringBuilder sb = new StringBuilder();
		Stack<Character> operators = new Stack<>();
		// 후위표기식으로 변환
		/*
		 * 중위 표기법을 후위 표기법으로 바꿀 때는 다음의 절차를 따른다.
		 * 
		 * 1) 피연산자가 들어오면 바로 출력한다.
		 * 
		 * 2) 연산자가 들어오면 자기보다 우선순위가 높거나 같은 것들을 빼고 자신을 스택에 담는다.
		 * 
		 * 3) 여는 괄호 '('를 만나면 무조건 스택에 담는다.
		 * 
		 * 4) 닫는 괄호 ')'를 만나면 '('를 만날 때까지 스택에서 출력한다.
		 * 
		 */
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// 1) 피연산자가 들어오면 바로 출력한다.
			if (c >= 'A' & c <= 'Z') {
				sb.append(c);
			} else {
				// 2) 연산자가 들어오면 자기보다 우선순위가 높거나 같은 것들을 빼고 자신을 스택에 담는다.
				if (c == '+' || c == '-' || c == '*' || c == '/') {
					while (!operators.empty() && prior(operators.peek()) >= prior(c)) {
						sb.append(operators.pop());
					}
					operators.push(c);
				}
				// 3) 여는 괄호 '('를 만나면 무조건 스택에 담는다.
				else if (c == '(') {
					operators.push(c);

				}
				// 4) 닫는 괄호 ')'를 만나면 '('를 만날 때까지 스택에서 출력한다.
				else if (c == ')') {
					while (true) {
						char ch = operators.pop();
						if (ch == '(') {
							break;
						} else {
							sb.append(ch);

						}
					}
				}
			}
		}

		// 스택에 남아있는 값 모두 추가
		while (!operators.empty()) {
			sb.append(operators.pop());
		}

		// 새로운 후위표기식 저장
		String newStr = sb.toString();
		System.out.println(newStr);
	}

	

	public static int prior(char c) {
		if (c == '+' || c == '-')
			return 1;
		if (c == '*' || c == '/')
			return 2;

		return 0;
	}

}