import java.util.*;

class Solution {
    
    public int solution(String name) {
        int answer = 0;
        int n = name.length();
        
        // 1. 알파벳 횟수
        for(int i = 0; i < n; i++){
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        
        // 2. 좌우로 이동
        int right = n-1;       // 오른쪽으로만 이동하는 경우
        
        for(int i = 0; i < n; i++){
            int next = i + 1;

            while (next < n && name.charAt(next) == 'A') {      // A로 연속된 구간 찾기
                next++;
            }
            
            // 오른쪽 갔다가 왼쪽으로 돌아오는 경우
            // i: 오른쪽으로 갔을 때, 마지막으로 방문한 위치
            // next: A구간 끝난 다음, 만나는 문자의 위치
            right = Math.min(right, i * 2 + (n - next));  

            // 왼쪽 먼저 갔다가 오른쪽으로 가는 경우
            right = Math.min(right, (n - next) * 2 + i);
        }
        
        answer += right;
        return answer;
    }
}