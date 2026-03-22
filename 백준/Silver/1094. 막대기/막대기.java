import java.io.*;
import java.util.*;

/*
 * (구) X를 2의 거듭제곱 합으로 표현했을 때, 1의 개수
 * : 현재 X를 2의 거듭제곱으로 표현하려고 함 -> 2의 거듭제곱으로 표현할 때, 1의 개수가 답
 * 
 * (1 << i) : 2^i 값을 만든다.
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		for(int i = 0; i < 7; i++) {
			if((X& (1 << i)) != 0) count++;
		}
		
		// 정답 출력
		System.out.println(count);

	}

}
