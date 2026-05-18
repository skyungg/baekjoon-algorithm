class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int div = n/2;  // 몫
        for(int i = 0; i < div; i++){
            sb.append("수박");
        }
        
        if(n%2 != 0){   // 짝수
            sb.append("수");
            
        }
        
        return sb.toString();
    }
}