import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int [] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		recursion(0);
		
		System.out.println(sb);
		
	}
	
	static void recursion(int depth) {
		if(depth == M) {
			for(int num : arr) {
				sb.append(num+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[depth] = i;
			recursion(depth+1);
		}
		
	}
	
	

}
