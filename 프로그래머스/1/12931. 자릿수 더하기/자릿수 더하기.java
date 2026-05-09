import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n != 0){
            answer += n % 10;   // 낮은 자리부터 더하기 시작
            n /= 10;
        }

        return answer;
    }
}