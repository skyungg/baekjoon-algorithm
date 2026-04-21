import java.io.*;
import java.util.*;

/*
 * 재귀, dp? -> N의 범위를 봐라 터짐.
 * -> 행렬로
 * */

public class Main {
	static final long MOD = 1000000007;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		
		// 구현
		long [][] result = pow(new long[][] {{1, 1}, {1, 0}}, N);
		
		// 출력
		System.out.println(result[0][1]);		// F(N);

	}
	
	static long [][] pow(long [][] A, long n){
		if(n == 1) return A;
		
		long [][] half = pow(A, n/2);
		long [][] result = multiply(half, half);
		
		if(n%2 == 1) result = multiply(result, A);
		
		return result;
		
	}
	
	static long [][] multiply(long [][] A, long [][] B){
		long [][] result = new long[2][2];
		
		result[0][0] = (A[0][0]*B[0][0] + A[0][1]*B[1][0]) % MOD;
		result[0][1] = (A[0][0]*B[0][1] + A[0][1]*B[1][1]) % MOD;
		result[1][0] = (A[1][0]*B[0][0] + A[1][1]*B[1][0]) % MOD;
		result[1][1] = (A[1][0]*B[0][1] + A[1][1]*B[1][1]) % MOD;
		
		return result;
	}
	

}
