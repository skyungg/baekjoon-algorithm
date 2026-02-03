import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());	// S의 길이
		char [] str = br.readLine().toCharArray();
		
		int count = 0;
		int result = 0;
		
		for(int i = 1; i < M-1; i++) {
			if(str[i-1] == 'I' && str[i] == 'O' &&str[i+1] == 'I') {
				count++;	// IOI인 경우
				
				if(count == N) {	// ioi 연속 세트가 N인 경우
					count--;
					result++;
				}
				i++;
			}else {
				count = 0;	// 연속 실패니 초기화
			}
		}

		System.out.println(result);

	}

}
