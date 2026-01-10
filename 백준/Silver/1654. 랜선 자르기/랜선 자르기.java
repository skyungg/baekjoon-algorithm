import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[K];
		long right = 0;
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}
		
		long maxLength = 0;
		long left = 1;
		while(left <= right) {
			long mid = ((long)(left+right))/2;
			
			long count = 0;	// mid길이로 나누었을 때 개수
			for(int i = 0; i < K; i++) {
				count += arr[i]/mid;
			}
			
			if(count >= N) {
				left = mid+1;
				maxLength = Math.max(maxLength, mid);
			}
			else right = mid-1;
		}
		
		System.out.println(maxLength);
	}

}
