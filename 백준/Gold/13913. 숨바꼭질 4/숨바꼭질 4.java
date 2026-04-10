import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean [] visited = new boolean[100001];
		int [] preNum = new int[100001];	// 이전 위치 저장
		
		Queue<Integer> que = new LinkedList<>();
		que.add(N);	// 현재 위치
		visited[N] = true;
		preNum[N] = -1;	// 시작점
		
		List<Integer> list = new ArrayList<>();
		while(!que.isEmpty()) {
			int curPoint = que.poll();
			
			if(curPoint == K) break;	// 도착지점 도달
			
			int [] nums = {curPoint-1, curPoint+1, curPoint*2};
			
			for(int num : nums) {
				if(num >= 0 && num <= 100000) {
					if(visited[num]) continue;
					visited[num] = true;
					preNum[num] = curPoint;	// 다음 도착위치의 이전값은 현재위치로 셋팅
					que.add(num);
				}
			}
		}
		
		// 정답 출력
		List<Integer> path = new ArrayList<>();
		int cur = K;
		while(cur != -1) {
			path.add(cur);
			cur = preNum[cur];
		}
		Collections.reverse(path);
		
		StringBuilder sb = new StringBuilder();
		sb.append(path.size()-1+"\n");	// 시간이니까 크기에서 -1하기
		for(int n : path) {
			sb.append(n+" ");
		}
		System.out.println(sb);

	}

}
