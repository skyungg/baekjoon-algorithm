import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zero_count = 0;
        
        while(!s.equals("1")){
            StringBuilder sb = new StringBuilder();
            
            // 1. 제거하기
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(ch == '1') sb.append(ch);
                else zero_count++;
            }
            
            // 2. 제거된 후 길이 측정
            int len = sb.toString().length();
            
            // 3. 길이를 2진법으로 전환
            s = Integer.toBinaryString(len);  
            
            // 이진 변환 횟수 증가
            cnt++;
        }
        
        return new int []{cnt, zero_count};
    }
}