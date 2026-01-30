import java.io.*;
import java.util.*;

public class Main {
	static class Point implements Comparable<Point>{
		int idx;
		int value;
		
		public Point(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
		
		public int compareTo(Point p) {
			return Integer.compare(this.value, p.value);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Point> list = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(new Point(i, Integer.parseInt(st.nextToken())));
		}
		
		// 오름차순 정렬
		Collections.sort(list);
		int [] result = new int[N];		// 정답 저장할 배열
		int index = 0;
		for(int i = 0; i < N; i++) {
			Point p = list.get(i);
			if(i > 0 && p.value == list.get(i-1).value) {
				result[p.idx] = index - 1;
			}else {
				result[p.idx] = index++;
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(result[i]+" ");
		}

		// 출력
		System.out.println(sb);
	}

}
