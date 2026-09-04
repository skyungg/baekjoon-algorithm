import java.util.*;

/*
A에서는 최솟값, B에서는 최댓값을 뽑아 곱하자.
*/
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        int len = A.length;     // 길이
        
        // 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < len; i++){
            answer += A[i] * B[len-i-1];
        }
        
        return answer;
    }
}