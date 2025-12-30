import java.io.*;
import java.util.*;

/*
 * 분석하기
 * "비어있는 공집합 S" -> 크기를 알 수 없으니 배열 선언 불가
 * */
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		List<Integer> changeList = new ArrayList<>();
		for(int i = 1; i <= 20; i++) changeList.add(i);
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			
			if(op.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				if(list.contains(num)) continue;	// 이미 존재 -> 넘어가기
				else list.add(num);
			}else if(op.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if(!list.contains(num)) continue;	// 없음 -> 넘어가기
				else list.remove(Integer.valueOf(num));
			}else if(op.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if(list.contains(num)) sb.append(1+"\n");	// 존재 -> 1 출력
				else sb.append(0+"\n");						// 존재 X -> 0출력
			}else if(op.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(list.contains(num)) list.remove(Integer.valueOf(num));
				else list.add(num);		// 추가
			}else if(op.equals("all")) {
				list.clear();
				list.addAll(changeList);
			}else {
				list.clear();		// 초기화
			}
		}
		
		System.out.println(sb);
	}

}
