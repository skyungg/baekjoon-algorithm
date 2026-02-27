import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] nums;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N+1];
		
		recursion(0, 1, new int[M]);	// 현재 depth, 현재 인덱스, 만들어진 수열
		
		System.out.println(sb);
		
	}
	
	static void recursion(int depth, int idx, int [] arr) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = idx; i <= N; i++) {
			arr[depth] = i;
			recursion(depth+1, i+1, arr);
		}
	}

}
