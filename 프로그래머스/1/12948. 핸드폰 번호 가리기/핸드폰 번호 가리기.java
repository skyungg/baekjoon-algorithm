class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();    // 전체 길이
        String preNumber = phone_number.substring(0, len-4);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < preNumber.length(); i++){
            sb.append("*");
        }
        sb.append(phone_number.substring(len-4, len));
        
        return sb.toString();
    }
}