import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();   // 주식가격이 떨어지지 않은 인덱스만 저장
        
        for(int i = 0; i < len; i++){
            // stack이 비어있지 않고, 현재 값이 이전값보다 작을 경우-> 이전 주식가격이 떨어진 경우
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){    
                int preIdx = stack.pop();
                answer[preIdx] = i - preIdx;
            }
            
            stack.push(i);  // 현재 인덱스 삽입
        }
        
        // 나머지 털기
        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = len-1-idx;
        }
            
            
        return answer;
    }
}