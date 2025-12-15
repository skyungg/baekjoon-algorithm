import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] nums;
	static int result = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		combination(0, 0, new int[3]);

		System.out.println(result);
	}
	
	static void combination(int count, int idx, int [] arr) {
		if(count == 3) {
			int sum = 0;
			for(int i = 0; i < 3; i++) sum += arr[i];
			
			if(sum <= M) {
				result = Math.max(result, sum);
			}
			
			return;
		}
		
		for(int i = idx; i < N; i++) {
			arr[count] = nums[i];
			combination(count+1, i+1, arr);
		}
	}

}
