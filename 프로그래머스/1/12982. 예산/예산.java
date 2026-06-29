import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(d);
        
        int curBudget = budget; // 현재 남아있는 예산 값
        int count = 0;
        for(int i = 0; i < d.length; i++){
            if(d[i] <= curBudget) {
                curBudget -= d[i];
                count++;
            }
            
            else break;
            
        }
        
        answer = count;
        return answer;
    }
}