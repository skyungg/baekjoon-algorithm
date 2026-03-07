import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] arr;
	static int [] nums;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		nums = new int[N];
		
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
	
	static void recursion(int depth) {
		if(depth == M) {
			for(int n: arr) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		
		int preNum = -1;
		for(int i = 0; i <N; i++) {
			if(nums[i] == preNum) continue;
			if(depth > 0 && nums[i] < arr[depth-1]) continue;
			
			arr[depth] = nums[i];
			preNum = arr[depth];
			recursion(depth+1);
		}
	}

}
