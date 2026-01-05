import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int [] dp = new int[1000001];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i = 4; i <= X; i++) {
			int num = Integer.MAX_VALUE;
		
			if(i%3 == 0) {
				num = Math.min(num, dp[i/3]+1); 
			}
			if(i%2 == 0) num = Math.min(num, dp[i/2]+1); 
			num = Math.min(num, dp[i-1]+1); 
			
			dp[i] = num;
		}
		
		
		// 결과
		System.out.println(dp[X]);
	}

}
