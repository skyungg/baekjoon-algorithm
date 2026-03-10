import java.io.*;
import java.util.*;

/*
 * 현재 값은 이전값 영향 받음 -> dp로 접근해보자
 * */
public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] maxDp = new int[3];
		int [] minDp = new int[3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			// 최댓값
			int maxLeft = Math.max(maxDp[0], maxDp[1]) + left;
			int maxMid = Math.max(maxDp[2], Math.max(maxDp[0], maxDp[1])) + mid;
			int maxRight = Math.max(maxDp[2], maxDp[1]) + right;
			
			// 최솟값
			int minLeft = Math.min(minDp[0], minDp[1]) + left;
			int minMid = Math.min(minDp[2], Math.min(minDp[0], minDp[1])) + mid;
			int minRight = Math.min(minDp[2], minDp[1]) + right;
			
			maxDp = new int[] {maxLeft, maxMid, maxRight};
			minDp = new int[] {minLeft, minMid, minRight};
		}

		// 출력
		System.out.println( Math.max(maxDp[2], Math.max(maxDp[0], maxDp[1]))+" "+Math.min(minDp[2], Math.min(minDp[0], minDp[1])));
		
		
	}

}
