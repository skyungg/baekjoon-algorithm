class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    public void dfs(int num, int idx, int [] numbers, int target){
        if(idx == numbers.length){
            if(num == target){
                answer++;
            }
            return;
        }
        
        dfs(num+numbers[idx], idx+1, numbers, target);
        dfs(num-numbers[idx], idx+1, numbers, target);
    }
}