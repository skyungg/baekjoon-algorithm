import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;     // 인용된 횟수의 최댓값
        
        // 오름 차순 정렬
        Arrays.sort(citations);
        
        int n = citations.length;
        
        for(int i = 0; i < n; i++){
            int cnt = n-i;
            
            if(citations[i] >= cnt){
                return cnt;
            }
        }
        
        return 0;
    }
}