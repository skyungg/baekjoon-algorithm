import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int tLen = t.length();
        int pLen = p.length();
        
        for(int i = 0; i <= tLen-pLen; i++){
            String tmp = t.substring(i, i+pLen);

            if(tmp.compareTo(p) <= 0) answer++;
        }
        
        return answer;
    }
}