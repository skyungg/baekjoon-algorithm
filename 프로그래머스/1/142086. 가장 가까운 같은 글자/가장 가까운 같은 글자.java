import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int [] alpha = new int[26];
        Arrays.fill(alpha, -1);
        
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i) - 'a';
            if(alpha[ch] == -1){
                answer[i] = -1;
                alpha[ch] = i;
            }else{
                answer[i] = i - alpha[ch];
                alpha[ch] = i;  //갱신
            }
        }
        return answer;
    }
}