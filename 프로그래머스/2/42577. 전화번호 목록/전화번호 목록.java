import java.util.*;

/*
접두어가 있음 -> false
접두어가 없음 -> true
*/

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);    // 정렬

        for(int i = 1; i < phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
            
        }
        return answer;
    }
}