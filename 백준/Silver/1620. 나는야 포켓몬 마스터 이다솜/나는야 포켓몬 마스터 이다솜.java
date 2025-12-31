import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> hmap = new HashMap<>();
		String [] arr = new String[N+1];
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			hmap.put(name, (i+1));
			arr[i+1] = name;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if(Character.isDigit(tmp.charAt(0))) sb.append(arr[Integer.parseInt(tmp)]+"\n");
			else sb.append(hmap.get(tmp)+"\n");
		}
		
		System.out.println(sb);
		

	}

}
