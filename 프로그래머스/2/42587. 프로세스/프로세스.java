import java.util.*;

/*
1. 우선순위 높은거 먼저
주의사항: 한번 실행한 거는 다시 큐에 넣지 않고 끝

** 숫자 높을수록 우선순위도 큼

*/
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<>();
        int n = priorities.length;  // 프로세스 개수
        
        for(int i = 0; i < n; i++) que.add(i);

        // 우선순위 정렬
        int [] arr = priorities.clone();       // 복사
        Arrays.sort(arr);     // 오름차순 정렬
        
        int count = 0;
        int idx = n-1;
        
        while(!que.isEmpty()){
            
            int target = que.poll();    // 맨 앞 원소 꺼내기
            
            if(arr[idx] == priorities[target]){
                idx--;  // 다음순서로 넘어가기
                count++;    // 맨 앞 원소 완전 실행때만 count 증가
                if(location == target) break;
            }else{
                que.add(target);    // 우선순위 안 맞음 다시 넣기
            }
            
            
            
        }
        return count;
    }
}