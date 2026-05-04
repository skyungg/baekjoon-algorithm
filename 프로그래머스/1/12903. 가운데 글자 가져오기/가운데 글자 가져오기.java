class Solution {
    public String solution(String s) {
        int len = s.length();
        int mid = len/2;
        
        StringBuilder sb = new StringBuilder();
        
        // 1. 홀-짝 판단
        if(len%2 == 0){     // 짝수
            sb.append(s.charAt((mid-1))+""+s.charAt(mid));
        }else{
            sb.append(s.charAt(mid));
        }
        return sb.toString();
    }
}