import java.io.*;
import java.util.*;

/*
 * 두 집합의 공통을 찾아내자.
 * 자료구조 어떤걸 선택할까?
 * 1) set -> 먼저 듣도 못한 사람을 저장하고(중복 없으니까), 그 다음 보도 못한 사람이 속한 여부를 파악해서 존재하면 해당 이름을 list에 추가 후 마지막으로 사전 정렬
 * 2) 배열로도 가능 -> 대신, 매번 전체 탐색을 해야한다.
 * 3) List 도 가능 -> contians를 해야하는데, set과의 시간복잡도 차이를 모르겠다.
 * 
 * 우선 set으로 진행 (현재 로직이 가능한 이유: 각 명단에 중복이 없음.
 * */

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 듣도 못한 사람 수
		int M = Integer.parseInt(st.nextToken());	// 보도 못한 사람 수
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int count = 0;
		List<String> list = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				list.add(name);
				count++;
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(String name : list) sb.append(name+"\n");
		
		System.out.println(count+"\n"+sb);
	}

}
