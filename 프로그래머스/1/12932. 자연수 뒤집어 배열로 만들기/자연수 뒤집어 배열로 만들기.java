class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str);
        String newStr = sb.reverse().toString();
        int answer [] = new int[newStr.length()];
        for(int i = 0; i < newStr.length(); i++){
            answer[i] = newStr.charAt(i) - '0';
        }
        return answer;
    }
}