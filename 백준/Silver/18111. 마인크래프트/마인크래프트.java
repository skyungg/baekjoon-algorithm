import java.io.*;
import java.util.*;

/*
 * 인벤토리에 넣기 : 1초
 * 인벤토리에서 꺼내기 : 2초
 * */
public class Main {
	static int N, M, B;
	static int [] block;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int minH = Integer.MAX_VALUE;
		int maxH = 0;
		block = new int[267];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				block[h]++;
				minH = Math.min(minH, h);
				maxH = Math.max(maxH, h);
			}
		}
		
		// 구현
		int height = 0;
		int resultTime = Integer.MAX_VALUE;
		for(int i = minH; i <= maxH; i++) {
			int curTime = solve(i);
			
			if(curTime < resultTime) {
				resultTime = curTime;
				height = i;
			}else if(curTime == resultTime) {
				if(i > height) {
					resultTime = curTime;
					height = i;
				}
			}
		}
		
		// 출력
		System.out.println(resultTime+" "+height);
	}
	
	static int solve(int standard) {
		int totalTime = 0;		// 총걸리는 시간
		int curStore = B;		// 현재 인벤토리안에 저장된 	블록 수
		
		for(int i = 0; i < 257; i++) {
			int count = block[i];		// 현재 높이에 따른 영역 수
			if(count == 0) continue;	// 해당하는 높이만큼 영역 존재X
			
			if(i < standard) {
				int cnt = count * (standard - i);		// 필요 개수
				
				totalTime += cnt;		// 삽입 1초
				curStore -= cnt;		// 필요한 개수만큼 차감
			}else if( i > standard) {
				int cnt = count *(i - standard);		// 제거해야하는 개수
				
				totalTime += cnt*2;		// 제거 2ch
				curStore += cnt;		// 제거한 수만큼 증가
				
			}
		}
		
		// 판단
		if(curStore < 0) return Integer.MAX_VALUE;	// 해당 높이로 진행X
		else return totalTime;	// 해당 높이로 진행 가능

	}

}
