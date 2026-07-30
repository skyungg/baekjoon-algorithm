class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int idx1 = 0;
        int idx2 = 0;
        
        for(int i = 0; i < goal.length; i++){
            boolean flag = false;
            
            String str = goal[i];   // 만들어야 하는 단어
            
            if(idx1 < cards1.length && cards1[idx1].equals(str)){
                flag = true;
                idx1++;
            }else if(idx2 < cards2.length && cards2[idx2].equals(str)){
                flag = true;
                idx2++;
            }
            
            if(!flag){
                answer = "No";
            };
        }
        
        if(answer.length() == 0) answer = "Yes";
        
        
        return answer;
    }
}