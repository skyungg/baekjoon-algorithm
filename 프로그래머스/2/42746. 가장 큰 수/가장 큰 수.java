import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String [] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);     // 문자열로 변환
        }

        // 정렬
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        
        // 맨 앞 0 체크
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String ar : arr) sb.append(ar);
        
        answer = sb.toString();
        return answer;
    }
}