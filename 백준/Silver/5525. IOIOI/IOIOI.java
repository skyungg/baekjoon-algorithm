import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());	// S의 길이
		String str = br.readLine();
		
		int result = 0;
		int length = 2*N+1;
		for(int i = 0; i <= M-length; i++) {
			String tmp = str.substring(i, i+length);

			boolean flag = true;
			for(int j = 0; j < length; j++) {
				if(j%2 == 0) {	// 짝수 -> I
					if(tmp.charAt(j) != 'I') {
						flag = false;
						break;
					}
				}else {
					if(tmp.charAt(j) != 'O') {
						flag = false;
						break;
					}
				}
			}
			if(flag) result++;
		}
		
		System.out.println(result);

	}

}
