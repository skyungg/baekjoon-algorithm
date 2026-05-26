/*
1. 가장 낮은 두개의 음식을 아래와 같이 특별한 방법으로 섞기
*/
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0; // 횟수
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 오름차순
        for(int sco : scoville) pq.add(sco);
        
        while(pq.peek() < K){
            // 가장 낮은 스코빌 지수가 K이상이기 전까지 반복
            if(pq.size() == 1){     // 음식의 스코빌 지수가 1개 밖에 없을 때
                answer = -1;
                break;
            }
            
            int a = pq.poll();
            int b = pq.poll();
            
            int newSco = a + (b*2);
            
            pq.add(newSco);
            
            answer++;
        }
         
        return answer;
    }
}