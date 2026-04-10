import java.util.*;
/*
stack 이용
그리디..?
*/

class Solution {
    public int solution(int[] order) {   
        int N = order.length;   // 상자 개수
        int count = 0;  // 트럭에 실리는 택배의 개수
        
        int idx = 0;    // 실어야 하는 택배 인덱스
        
        Stack<Integer> stack = new Stack<>();      // 보조 컨테이너벨트
       
        for(int i = 1; i <= N; i++){
            stack.push(i);  // 일단 넣기
            
            while(!stack.isEmpty() && (stack.peek() == order[idx])){
                    stack.pop();
                    count++;
                    idx++;      // 기사님의 다음 택배 상자로 넘어가기
            }
        }
        
        return count;
    }
}