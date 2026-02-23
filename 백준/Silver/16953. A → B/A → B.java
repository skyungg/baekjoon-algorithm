import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int result = 1;
		
		// 둘 중 하나의 방법으로 만들어진게 확실할 때가 최적의 선택
		while(A < B) {
			if(B % 10 == 1) {	// A에 1을 추가해서 만든경우
				B /= 10;
			}else if(B%2 == 0) {	// A*2에 해당
				B /= 2;
			}else break;	// 둘 다 해당 안 됨
			result++;
		}	
		
		if(B == A) System.out.println(result);
		else System.out.println(-1);

	}

}
