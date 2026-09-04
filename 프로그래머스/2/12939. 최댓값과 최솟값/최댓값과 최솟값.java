import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String [] tmp = s.split(" ");
        
        int len = tmp.length;
        int [] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }
        
        // 정렬
        Arrays.sort(arr);
        answer = arr[0] + " " + arr[len-1];
        return answer;
    }
}