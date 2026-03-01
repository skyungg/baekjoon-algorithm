import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] arr;
	static int [] nums;
	static boolean [] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		nums = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		recursion(0);
		
		// 출력
		System.out.println(sb);
	}
	
	static void recursion(int depth) {
		if(depth == M) {
			for(int num : nums) {
				sb.append(num+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]){
				visited[i] = true;
				nums[depth] = arr[i];
				recursion(depth+1);
				visited[i] = false;
			}
		}
	}
	

}
