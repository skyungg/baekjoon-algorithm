import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++) que.offer(0);
        
        int time = 0;
        int curWeight = 0;
        int idx = 0;

        while(idx < truck_weights.length){
            time++;
            
            // 한 칸 이동하기
            curWeight -= que.poll();
            
            if(curWeight + truck_weights[idx] <= weight){
                que.offer(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++;
            }else{
                que.offer(0);
            }
        }
        
        return time + bridge_length;
    }
}