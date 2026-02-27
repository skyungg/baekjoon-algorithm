import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		recursion(0, new int[M]);	// 현재 depth, 현재 인덱스, 만들어진 수열
		
		System.out.println(sb);
		
	}
	
	static void recursion(int depth,int [] arr) {
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				recursion(depth+1, arr);
				visited[i] = false;
			}
		}
	}

}
