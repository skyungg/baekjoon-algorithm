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
				if(j == 0) map[i][j] += map[i-1][j];	// 맨 왼쪽
				else if(j == i) map[i][j] += map[i-1][j-1];		// 맨 왼쪽
				else map[i][j] += Math.max(map[i-1][j-1], map[i-1][j]);
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
