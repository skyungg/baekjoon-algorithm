import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
        
        // 1. String 배열로 변환하기
        String [] arr = new String[len];
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 정렬하기
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));   // 큰 값대로
        
        // 예외 -> 맨 앞이 0인 경우
        if(arr[0] .equals("0")) return "0";
        
        // 3. 정답 만들기
        StringBuilder sb = new StringBuilder();
        for(String str : arr) sb.append(str);
        
        answer = sb.toString();
    
        return answer;
    }
}