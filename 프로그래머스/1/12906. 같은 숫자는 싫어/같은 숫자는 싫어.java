import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);   // 초기값 삽입
        int preNum = arr[0];
        
        for(int i = 1; i < arr.length; i++){
            if(preNum != arr[i]){
                list.add(arr[i]);
                preNum = arr[i];
            }
        }
        
        // 배열로 만들기
        int len = list.size();
        int [] answer = new int[len];
        for(int i = 0; i < len; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}