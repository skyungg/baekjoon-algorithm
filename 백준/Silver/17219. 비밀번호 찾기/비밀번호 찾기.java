import java.io.*;
import java.util.*;

/*
 * 하나의 사이트 주소에 대해 하나의 비밀번호가 존재
 * -> 사이트가  key, 비밀번호가 value
 * -> map이 적합하다고 판단
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hmap = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String address = st.nextToken();
			String pwd = st.nextToken();
			hmap.put(address, pwd);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			
			sb.append(hmap.get(str)+"\n");
			
		}
		
		System.out.println(sb);
	}

}
