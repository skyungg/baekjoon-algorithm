import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int num = 0;
		
		boolean flag = true;
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int target = Integer.parseInt(br.readLine());
			if(num <= target) {			// 현재 taget인 숫자보다 stack에 넣은 숫자가 작은 수인경우 -> 해당 수까지 stack에 넣기
				while(num < target) {
					num++;
					stack.push(num);
					sb.append("+\n");
				}
			}
			
			if(stack.peek() == target) {
				stack.pop();	// 꺼내기
				sb.append("-\n");
			}else {
				flag = false;
				break;
			}
		}
		
		System.out.println(flag? sb: "NO");

	}

}
