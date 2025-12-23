import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {		// 최근에 쓴 수 지우기
				stack.pop();	
			}
			else {
				stack.add(num);
			}
		}
		
		int sum = 0;

		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);	

	}

}
