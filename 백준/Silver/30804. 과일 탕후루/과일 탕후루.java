import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i= 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		HashMap<Integer, Integer> hmap = new HashMap<>();	// 과일 종류별 분류 
		int start = 0;
		int result = 0;
		
		for(int end = 0 ; end < N; end++) {
			hmap.put(arr[end], hmap.getOrDefault(arr[end], 0)+1);
			
			while(hmap.size() > 2) {
				// 두 종류 이상 -> 과일 조절 -> 앞에서부터 제거
				hmap.put(arr[start], hmap.get(arr[start])-1);	// 앞의 과일 하나 제거
				if(hmap.get(arr[start]) == 0) hmap.remove(arr[start]);	// 과일 개수 0 -> 해당 과일 삭제
				
				start++;	// 앞의 과일 삭제했으니까, 남아있는 과일중 맨 앞 위치 변경
			}
			
			result = Math.max(result, end-start+1);	
		}
		
		// 정답 출력 
		System.out.println(result);


	}

}
