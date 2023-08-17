
import java.util.Scanner;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
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
			for (int i = 0; i < len; i++) {
				char c = str.charAt(i);
				// 1) 피연산자가 들어오면 바로 출력한다.
				if (c >= '0' & c <= '9') {
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

			// 후위표기식 계산

			/*
			 * 후위 표기법을 계산할 때는 다음의 절차를 따른다.
			 * 
			 * 1) 피연산자를 만나면 스택에 담는다.
			 * 
			 * 
			 * 
			 * 2) 연산자를 만나면 스택에서 두 개의 연산자를 꺼내서 연산한 뒤에 그 결과를 스택에 담는다.
			 * 
			 * 
			 * 3) 연산을 마치고 스택에 남아있는 하나의 피연산자가 연산 수행 결과이다.
			 */
			Stack<Integer> calculator = new Stack<>();
			for(int i=0; i<newStr.length(); i++) {
				char c = newStr.charAt(i);
				// 1) 피연산자를 만나면 스택에 담는다.
				if (c >= '0' & c <= '9') {
					calculator.push((int)(c-'0'));
				} 
				// 2) 연산자를 만나면 스택에서 두 개의 연산자를 꺼내서 연산한 뒤에 그 결과를 스택에 담는다.
				else if (c=='+'||c=='-'||c=='*'||c=='/') {
					int second = calculator.pop();
					int first = calculator.pop();
					int result = 0;
					switch(c) {
					case '+':
						result = first+second;
						break;
					case '-':
						result = first-second;
						break;
					case '*':
						result = first*second;
						break;
					case '/':
						result = first/second;
						break;
					}
					calculator.push(result);
				}
			}
			
			// 3) 연산을 마치고 스택에 남아있는 하나의 피연산자가 연산 수행 결과이다.
			int answer = calculator.pop();
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}

	public static int prior(char c) {
		if (c == '+' || c == '-')
			return 1;
		if (c == '*' || c == '/')
			return 2;

		return 0;
	}

}