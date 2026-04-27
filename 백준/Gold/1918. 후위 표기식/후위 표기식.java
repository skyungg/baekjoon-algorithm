import java.io.*;
import java.util.*;

/*
 * 연산자 우선순위 찾기 + 스택 사용
 * 
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(char ch : str.toCharArray()) {
			
			// 1.피연산자
			if(Character.isAlphabetic(ch)) {
				sb.append(ch);
			}
			
			// 2. '('
			else if(ch == '(') {
				stack.push(ch);
			} 
			
			// 3. ')'
			else if(ch == ')') {
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();	// '(' 제거
			}
			
			// 4. 연산자
			else {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
					sb.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		
		// 남은 연산자 처리
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);

	}
	
	// 우선순위 판별 함수
	static int priority(char c) {
		if(c == '*' || c == '/') return 2;	// 연산자 1등
		if(c == '+' || c == '-') return 1;	// 연산자 2등
		
		return 0;	// 그외
	}

}
