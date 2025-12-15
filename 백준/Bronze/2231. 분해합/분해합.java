import java.io.*;
import java.util.*; 

public class Main {
	static int num;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();	// 현재 길이
		
		num = Integer.parseInt(str);
		
		for(int i = 1; i <= len; i++) {
			combination(i, 0, new int[i]);
		}
		
		// 결과 출력
		if(result == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(result);

	}
	
	static void combination(int depth, int count, int [] nums) {
		if(depth == count) {
			int tmp = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < nums.length; i++) {
				sb.append(nums[i]);
				tmp += nums[i];
			}
			
			tmp += Integer.parseInt(sb.toString());

			if(tmp == num) {
				result = Math.min(result, Integer.parseInt(sb.toString()));
			}
			
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			nums[count] = i;
			combination(depth, count+1, nums);
		}
	}

}
