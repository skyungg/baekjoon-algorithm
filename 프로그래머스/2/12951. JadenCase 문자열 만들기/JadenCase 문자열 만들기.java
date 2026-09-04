import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;        // 첫문자 여부 확인
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == ' '){      // 공백인 경우
                sb.append(ch);
                flag = true;
            }else{
                if(flag){
                    // 이전 문자가 공백 -> 현재 문자가 첫문자
                    sb.append(Character.toUpperCase(ch));
                    flag = false;   // 그 뒤로부터는 첫문자 아님
                }else{
                    sb.append(Character.toLowerCase(ch));
                }
            }
        }
        
        return sb.toString();
    }
}