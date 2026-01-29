import java.io.*;
import java.util.*;

/*
 * 인벤토리에 넣기 : 1초
 * 인벤토리에서 꺼내기 : 2초
 * */
public class Main {
	static int N, M, B;
	static int [][] map;
	static int height = 0;
	static int time = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int maxH = 0;
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		
		// 구현
		
		for(int i = 0; i <= maxH; i++) {
			solve(i);
		}
		
		// 출력
		System.out.println(time+" "+height);
	}
	
	static void solve(int standard) {
		int store = B;		// 현재 인벤토리 수
		int curTime = 0;
		
		// 1. 블록 제거 ( +2)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > standard) {
					curTime += (map[i][j]-standard)*2;
					store += (map[i][j] - standard);
				}
			}
		}
		
		// 2. 블록 삽입 ( +1)
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (map[i][j] < standard) {
					int count = standard - map[i][j];
					
					if(store >= count) {
						store -= count;
						curTime += count;
					}else return;
				}
			}
		}
		
		if(curTime < time) {
			time = curTime;
			height = standard;
		}else if(curTime == time) {
			if(standard > height) {
				time = curTime;
				height = standard;
			}
		}
	}

}
