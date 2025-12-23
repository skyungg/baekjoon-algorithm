import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Integer, Integer> hmap = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			hmap.put(n, hmap.getOrDefault(n, 0)+1);
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(hmap.containsKey(num)) sb.append(hmap.get(num)+" ");
			else sb.append("0 ");
		}
		
		System.out.println(sb);
	}

}
