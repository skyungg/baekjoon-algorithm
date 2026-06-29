import java.util.*;

class Solution {
    int count = 0;
    public int solution(int[] number) {
        int answer = 0;
        bfs(number, 0, 0, 0);
        
        
        return count;
    }
    
    public void bfs(int [] number, int sum, int depth, int start){
        if (depth == 3){
            if(sum == 0){
                count++;
            }
            
            return;
        }
        
        for(int i = start; i < number.length; i++){
            bfs(number, sum+number[i], depth+1, i+1);
        }
    }
}