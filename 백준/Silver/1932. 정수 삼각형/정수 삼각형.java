import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i+1; j++) {
				int left = 0;
				int right = 0;
				if(j-1 >= 0) left = map[i-1][j-1];
				if(j <= i) right = map[i-1][j];
				
				map[i][j] += Math.max(left, right);
			}
		}
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			result = Math.max(map[N-1][i], result);
		}
		
		// 정답
		System.out.println(result);
	}

}
