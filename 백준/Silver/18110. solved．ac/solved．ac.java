import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 정렬하기
		Arrays.sort(arr);
		
		// 15% 정하기
		int k = (int) Math.round(N*0.15);
		
		int sum = 0;
		for(int i = k; i < N-k; i++) {
			sum += arr[i];
		}
		
		System.out.println(Math.round((double)sum/(N-k*2)));

	}

}
