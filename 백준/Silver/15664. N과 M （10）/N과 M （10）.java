import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] nums;
	static int [] arr;
	static boolean [] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		arr = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 정렬
		Arrays.sort(nums);
		
		sb = new StringBuilder();
		// 재귀
		recursion(0, 0);
		
		// 출력
		System.out.println(sb);

	}
	
	static void recursion(int depth, int idx) {
		if(depth == M) {
			for(int n : arr) {
				sb.append(n+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(visited[i]) continue;
			if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
			
			visited[i] = true;
			arr[depth] = nums[i];
			recursion(depth+1, i+1);
			visited[i] = false;
		}
		
	}

}
