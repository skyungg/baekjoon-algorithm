class Solution {
    public int solution(String s) {
        int answer = 0;
        
        if(Character.isDigit(s.charAt(0))){
            // 숫자로 시작 -> 숫자
            answer = Integer.parseInt((s));
        }else{
            if(s.charAt(0) == '-'){
                answer = -1* Integer.parseInt(s.substring(1, s.length()));
            }
            else{
                answer = Integer.parseInt(s.substring(1, s.length()));
            }
        }
           
        return answer;
    }
}