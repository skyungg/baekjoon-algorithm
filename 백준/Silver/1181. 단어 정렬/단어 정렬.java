import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(!list.contains(str)) list.add(str); 
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) return s1.compareTo(s2);
				return s1.length() - s2.length();
			}
		});

		
		StringBuilder sb = new StringBuilder();
		for(String str : list) sb.append(str+"\n");
		
		System.out.println(sb);

	}

}
