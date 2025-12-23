import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') stack.push('(');
				else {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}else stack.pop();
				}
			}
			
			if(flag && stack.isEmpty()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);

	}

}
