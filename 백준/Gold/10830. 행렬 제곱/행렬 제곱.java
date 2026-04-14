import java.io.*;
import java.util.*;

/*
 * 추구미: 행렬을 빠르게 제곱하는 방법
 * -> 행렬 A를 B번 곱하라
 * -> 말 그대로 하면 시간초과 및 메모리 초과
 * A^B = (A^(B/2))^2
 *     = (A^B(/2))^2 * A (홀수)
 * */
public class Main {
	static final int MOD = 1000;
	static int [][] map;
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i <  N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken())%MOD;
			}
		}
		
		// 구현
		int [][] result = pow(map, B);
		
		// 정답 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	
	public static int [][] pow(int [][] arr, long exp){
		if(exp == 1L) {		// 지수가 1 -> 더이상 곱셈X
			return arr;
		}
		
		int [][] divid = pow(arr, exp/2);	// 절반만 계산하기
		
		divid = multiply(divid, divid);	// 제곱 계산
		
		if(exp%2 != 0L) {					// 홀수면 -> A를 한 번 더 곱함
			divid = multiply(divid, map);	
		}
		
		return divid;
	}
	
	// 행렬 곱
	public static int [][] multiply(int [][] a, int [][] b){
		int [][] gop = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					gop[i][j] += a[i][k] * b[k][j];		// 표준 행렬 곱
					gop[i][j] %= MOD;		// 1000으로 나눈 나머지
				}
			}
		}
		
		return gop;
	}

}
