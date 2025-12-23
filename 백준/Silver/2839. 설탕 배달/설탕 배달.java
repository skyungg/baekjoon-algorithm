import java.io.*;
import java.util.*;

/*
 * 아이디어: 초기 -> 중복조합: 시간초과
 *         그리디
 * */
public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		boolean flag = false;
		while(N >= 0) {
			if(N % 5 == 0) {		// 5로 확실히 나누어 질 때만 5로 나누는게 깔끔.
				count += N/5;
				flag = true;
				break;
			}
			N -= 3;			// 5로 나누어떨어지지 않으면 -3씩해서 간보기
			count++;
		}
		
		if(!flag) System.out.println(-1);
		else System.out.println(count);
		
		
	}


}
