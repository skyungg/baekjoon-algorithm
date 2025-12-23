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
			int count = 0;
			boolean flag = true;
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') count++;
				else {
					if(count == 0) {
						flag = false;
						break;
					}else count--;
				}
			}
			
			if(flag && count == 0) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);

	}

}
