import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean [] prime = new boolean[M+1];
		
		prime[0] = true;
		prime[1] = true;
		
		// 1. 에라토스테네스의 체
		for(int i = 2; i <= Math.sqrt(M); i++) {
			if(prime[i]) continue;	// 해당 수가 소수가 아닌 경우
			
			for(int j = i*i; j <= M; j += i) {
				prime[j] = true;
			}
		}
		
		// 2. 결과 출력하기
		StringBuilder sb = new StringBuilder();
		for(int i = N; i <= M; i++) {
			if(!prime[i]) sb.append(i+"\n");
		}
		
		System.out.println(sb);

	}

}
