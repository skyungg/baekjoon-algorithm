import java.io.*;
import java.util.*;

/*
 * N: 선택할 수 있는 원소가 N개
 * 각 원소는 선택 or 안 선택 2가지
 * 전체 경우의 수: 2^N
 * 
 * 각 비트는 -> 포함여부.
 * 
 * (1 << j) : j번째 비트를 1로 만들기
 * (i & (1 << j) : i에서 j번째 비트만 확인
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 선택할 수 있는 정수가 N개
		int S = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 비트마스크
		int count = 0;
		for(int i = 1; i < (1 << N); i++) {	// i -> 부분집합 하나 의미 -> 모든 부분집합 돌기
			int sum = 0;
			
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {	// i라는 부분집합에 j번째 원소가 포함되어 있는지?
					sum += arr[j];
				}
			}
			
			if(sum == S) count++;
		}
		
		// 정답
		System.out.println(count);
		 
	}

}
