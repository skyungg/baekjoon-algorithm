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
        int boxIdx = 1;    // 현재 택배 인ㄷ게스
        
        Stack<Integer> stack = new Stack<>();      // 보조 컨테이너벨트
       
        while(idx < N){
            if(!stack.isEmpty() && stack.peek() > order[idx]) break;
            
            if(boxIdx == order[idx]){   // 기존 컨테이너 벨트에 있는 것과 기사님 순서 일치
                count++;  
                idx++;
                boxIdx++;
                continue;
            }else{
                // 1. 보조 컨테이너 벨트 확인하기
                while(!stack.isEmpty() && (stack.peek() == order[idx])){
                    stack.pop();
                    count++;
                    idx++;      // 기사님의 다음 택배 상자로 넘어가기
                }
                
                // 2. 보조 컨테이너벨트에 수납하기
                stack.push(boxIdx);
                boxIdx++;
            }
            
            
            
            
        }

        
        return count;
    }
}