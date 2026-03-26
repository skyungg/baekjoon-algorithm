import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int [][] dp = new int[len1+1][len2+1];	// dp[i][j] : str1의 앞 i개, str2의 앞 j개
		
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;	// 현재 idx에서 같은 문자 -> 이전 lcs에 +1
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);	// str1[i]를 버리거나, str2[j]를 버리거나 둘 중하나 선택
				}
			}
		}
		
		System.out.println(dp[len1][len2]);
	}

}
