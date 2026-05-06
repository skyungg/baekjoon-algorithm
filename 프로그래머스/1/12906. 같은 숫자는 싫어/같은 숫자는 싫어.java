/*
배열의 순서 유지 필요
1. STACK 써서, 마지막에 뒤집기
2. QUE 써서 그대로 사용하기

*/
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        // 1. STACK 쓰기
        Stack<Integer> stack = new Stack<>();
        for(int a : arr){
            stack.push(a);
        }
        
        List<Integer> list = new ArrayList<>();

        while(!stack.isEmpty()){
            int num = stack.pop();
            if(list.isEmpty()) list.add(num);
            else{
                if(list.get(list.size()-1) != num) list.add(num);
            }
        }
        
        // 배열로 만들기
        int len = list.size();
        int [] answer = new int[len];
        for(int i = len-1; i >= 0; i--){
            answer[len-i-1] = list.get(i);
        }

        return answer;
    }
}