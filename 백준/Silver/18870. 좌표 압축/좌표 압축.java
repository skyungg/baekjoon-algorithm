import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int[N];
		int [] tmp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			tmp[i] = nums[i];
		}
		
		
		// 오름차순 정렬
		Arrays.sort(tmp);
		int maxNum = tmp[0];
		int count = 1;			// 중복 제거한 길이 
		for(int i = 1; i < N; i++) {
			if(tmp[i] > maxNum) {
				maxNum = tmp[i];	// 배열 속 최댓값 갱신
				count++;
			}
		}
		
		int [] result = new int[count];		// 중복 제거한 길이만큼 생성 -> 찐 중복제거한만큼 배열 만들기
		result[0] = tmp[0];
		maxNum = tmp[0];
		count = 1;
		for(int i = 1; i < N; i++) {
			if(tmp[i] > maxNum) {
				result[count++] = tmp[i];	// 중복제거한 값들을 저장
				maxNum = tmp[i];
			}
		}
		
		// 기존 배열에서 좌표 압축 실행 -> 이분 탐색 통해 값 탐색
		int left = 0;
		int right = count-1;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while(index < N) {
			int mid = (left+right)/2;
			
			if(result[mid] < nums[index]) left = mid+1;
			else if(result[mid] > nums[index]) right = mid-1;
			else {
				left = 0;				// 포인터 초기화
				right = count-1;
				sb.append(mid+" ");
				index++;
			}
		}

		// 출력
		System.out.println(sb);
	}

}
