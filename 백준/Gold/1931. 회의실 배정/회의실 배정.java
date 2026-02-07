import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int []> room = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			room.add(new int[] {start, end});
		}
		
		// 정렬 (끝, 시작 시간 오름차순)
		Collections.sort(room, (a, b)-> {
			if(a[1] == b[1]) return a[0] - b[0];
			else return a[1] - b[1];
		});
		
		// 회의의 최대 개수 찾기
		int idx = 0;
		int preEnd = 0;	// 이전 타임 끝나는 시간
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			int [] cur = room.get(i);	// 현재값
			
			if(cur[0] >= preEnd) {	// i번째 사용 가능
				preEnd = cur[1];	// 끝나는 시간 갱신
				result++;
			}
		}

		// 정답 출력
		System.out.println(result);
	
	}

}
