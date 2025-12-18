import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String [] arr = new String[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) return s1.compareTo(s2);
				return s1.length() - s2.length();
			}
		});

		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]+"\n");
		
		for(int i = 1; i < N; i++) {
			if(!arr[i].equals(arr[i-1])) sb.append(arr[i]+"\n");
		}
		
		System.out.println(sb);

	}

}
