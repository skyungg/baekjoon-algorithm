import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int n = number.length();    // 총 자릿수
        
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < n; i++){
            int num = number.charAt(i) - '0';
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < num){
                stack.pop();
                k--;
            }
            
            stack.push(num);
        }
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString();
        return answer;
    }
}