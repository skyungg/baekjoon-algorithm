import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	// 테스트케이스 수
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());	// 의상 수
			Map<String, List<String>> map = new HashMap<>();
			
			
			// 입력 받기
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				
				if(map.containsKey(type)) {
					map.get(type).add(name);
				}else {
					map.put(type, new ArrayList<>());
					map.get(type).add(name);
				}				
			}
			
			// 조합
			int total_count = 1;
			for(String key : map.keySet()) {
				int count = map.get(key).size();
				
				total_count *= (count+1);
			}
			
			sb.append((total_count-1)+"\n");
		}
		
		System.out.println(sb);

	}

}
