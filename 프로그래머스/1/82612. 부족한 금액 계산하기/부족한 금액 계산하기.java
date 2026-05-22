class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long [] dp = new long[count+1];
        dp[1] = price;
        
        for(int i = 2; i <= count; i++){
            dp[i] = dp[i-1]+(price*i);
        }
        
        long dif = money - dp[count];
        if(dif < 0) answer = Math.abs(dif);
        else answer = 0;

        return answer;
    }
}