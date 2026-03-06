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
		
		nums = new int[N];
		arr = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(nums);
		
		// 재귀
		sb = new StringBuilder();
		recursion(0);
		
		// 출력
		System.out.println(sb);
		
	}
	
	/*
	 * point: 같은 depth에서 같은 숫자 건너뛰기
	 * */
	static void recursion(int depth) {
		if(depth == M) {
			for(int n : arr) {
				sb.append(n+" ");
			}
			sb.append("\n");
			
			return;
		}
		
		int preNum = -1;	// 이전 순서 값
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;	// 이미 사용 완료
			if(nums[i] == preNum) continue;	// 같은값 반복
			
			visited[i] = true;
			arr[depth] = nums[i];
			preNum = arr[depth];
			recursion(depth+1);
			visited[i] = false;
		}
	}

}
