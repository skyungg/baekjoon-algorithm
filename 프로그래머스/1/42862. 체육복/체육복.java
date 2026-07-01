import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int [] student = new int[n];    // 각 학생별 체육복 소지 개수
        Arrays.fill(student, 1);

        // 도난 개수 빼기
        for(int idx : lost){
            student[idx-1]--;
        }
        
        // 여벌 체육복 더하기
        for(int idx : reserve){
            student[idx-1]++;
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            // 체육복이 없는 경우
            if(student[i] == 0){
                // 1. 앞의 학생에게 빌리기
                if(i > 0 && student[i-1] == 2){
                    student[i]++;       // 증가
                    student[i-1]--;     // 빌려주었으니 감소
                }
                
                else if(i < n-1 && student[i+1] == 2){
                    student[i]++;       // 증가
                    student[i+1]--;     // 빌려주었으니 감소
                }
            }
            
            // 최종적으로 체육복 있는 경우
            if(student[i] > 0) count++;
            
        }

        return count;
    }
}