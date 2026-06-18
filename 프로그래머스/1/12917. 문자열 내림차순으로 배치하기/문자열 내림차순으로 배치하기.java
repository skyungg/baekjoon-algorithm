import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String [] arr = s.split("");
        Arrays.sort(arr);
        for(int i = s.length()-1; i >= 0; i--) answer.append(arr[i]);
        return answer.toString();
    }
}