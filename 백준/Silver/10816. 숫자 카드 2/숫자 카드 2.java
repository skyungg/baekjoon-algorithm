import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int [] nums = new int[20000001];		// 음수인 값을 위하여 기존의 크기 2배하기
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			nums[n+10000000]++;		// 10000000더해서 인덱스 만들기
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			sb.append(nums[Integer.parseInt(st.nextToken()) + 10000000]+" ");
		}
		
		System.out.println(sb);
	}

}
