import java.util.*;

/*
dfs 접근해보기
*/
class Solution {
    static int answer = 0;
    static int[] numbers;
    static int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        dfs(0, 0);
            
        return answer;
    }
    
    static void dfs(int count, int sum){
        if(count == numbers.length){
            if(sum == target) answer++;
            return;
        }
        
        dfs(count+1, sum+numbers[count]);   // 덧셈
        dfs(count+1, sum-numbers[count]);   // 뺄셈
    }
}