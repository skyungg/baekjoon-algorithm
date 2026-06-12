class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String [] str = String.valueOf(x).split("");    // 문자열 배열로 전환
        int sum = 0;
        
        for(String s : str) sum += Integer.parseInt(s);
        
        if(x%sum != 0) answer = false;     
        
        return answer;
    }
}