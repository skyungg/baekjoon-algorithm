import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String [] arr = s.split("");
        Arrays.sort(arr);
        for(int i = 0; i < s.length(); i++) answer.append(arr[i]);

        return answer.reverse().toString();
    }
}