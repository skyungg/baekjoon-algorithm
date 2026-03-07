import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] nums;
	static int [] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(nums);
		
		// 구현
		sb = new StringBuilder();
		recursion(0);
		
		// 출력
		System.out.println(sb);
		
	}
	
	static void recursion(int depth) {
		if(depth == M) {
			for(int n : arr) {
				sb.append(n+" ");
			}
			sb.append("\n");
			return;
		}
		
		int preNum = -1;
		for(int i = 0; i < N; i++) {
			if(preNum == nums[i]) continue;
			
			preNum = nums[i];
			arr[depth] = nums[i];
			recursion(depth+1);
		}
	}

}
