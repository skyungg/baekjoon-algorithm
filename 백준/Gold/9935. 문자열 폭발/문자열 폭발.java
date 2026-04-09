import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String popStr = br.readLine();	// 폭발 문자열
		
		int len = popStr.length();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i <  str.length(); i++) {
			stack.push(str.charAt(i));
			
			if(stack.size() >= len) {
				boolean flag = true;
				
				for(int j = 0; j < len; j++) {
					if(stack.get(stack.size()-len+j) != popStr.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					for(int j = 0; j < len; j++) {
						stack.pop();
					}
				}
			}
		}
		
		// 정답출력
		if(stack.isEmpty()) {
			System.out.println("FRULA");
		}else {
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
			System.out.println(sb.reverse());
		}
	}

}
