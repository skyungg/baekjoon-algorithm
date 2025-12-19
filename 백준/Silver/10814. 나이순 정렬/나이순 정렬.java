import java.io.*;
import java.util.*;

public class Main {
	static class User implements Comparable<User>{
		int age;
		String name;
		int idx;
		
		public User(int age, String name, int idx) {
			this.age = age;
			this.name = name;
			this.idx = idx;
		}
		
		@Override
		public int compareTo(User u) {
			if(this.age == u.age) return this.idx - u.idx;
			return this.age - u.age;
		}
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<User> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new User(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(User u : list) {
			sb.append(u.age+" "+u.name+"\n");
		}
		
		System.out.println(sb);
	}

}
