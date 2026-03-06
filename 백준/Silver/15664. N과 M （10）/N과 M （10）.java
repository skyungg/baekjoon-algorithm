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
		
		int preNum = -1;
		for(int i = idx; i < N; i++) {
			if(preNum == nums[i]) continue;	// 같은 depth에서 같은 숫자 중복 방지

			arr[depth] = nums[i];
			preNum = arr[depth];
			recursion(depth+1, i+1);
		}
		
	}

}
