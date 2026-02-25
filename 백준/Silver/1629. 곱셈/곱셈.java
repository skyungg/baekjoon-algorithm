import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(A, B, C));
		
	}
	
	static long solve(long A, long B, long C) {
		if(B == 1) return A % C;
		
		long tmp = solve(A, B/2, C);
		
		if(B %2 == 0) {
			return (tmp*tmp) % C;
		}else {
			return ((tmp * tmp) % C * A) % C;
		}
	}

}
