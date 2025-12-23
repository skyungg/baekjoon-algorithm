import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			
			if(str.length() == 1 && str.equals(".")) break;
			
			String [] arr = str.split(" ");
			
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length(); j++) {
					if(arr[i].charAt(j) == '(' || arr[i].charAt(j) == '[') stack.push(arr[i].charAt(j));
					else if(arr[i].charAt(j) == ')') {
						if(stack.isEmpty()) {
							flag = false;
							break;
						}else {
							if(stack.peek() == '(') stack.pop();
							else {
								flag = false;
								break;
							}
						}
						
					}
					else if(arr[i].charAt(j) == ']') {
						if(stack.isEmpty()) {
							flag = false;
							break;
						}else {
							if(stack.peek() == '[') stack.pop();
							else {
								flag = false;
								break;
							}
						}
						
					}
				}
				
				if(!flag) break;
				
			}
			
			if(flag && stack.isEmpty()) sb.append("yes\n");
			else sb.append("no\n");
			
		}
		
		// 정답 출력
		System.out.println(sb);

	}

}
