import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String num = Long.toString(n);
        String [] str = num.split("");
        Arrays.sort(str);
        StringBuilder sb = new StringBuilder();
        
        for(int i = num.length()-1;  i >= 0; i--){
            sb.append(str[i]);
        }
        
        return Long.parseLong(sb.toString());
    }
}