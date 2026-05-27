import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int [] day = new int[progresses.length];
        
        // 남은 일수 계산
        for(int i = 0; i < progresses.length; i++){
            int rest = 100 - progresses[i];
            int tmp = rest/speeds[i];
            if(rest%speeds[i] != 0) tmp++;
            
            day[i] = tmp;
        }
        
        List<Integer> list = new ArrayList<>();
        
        int preNum = day[0];
        list.add(1);    // 첫 번째 기능
        for(int i = 1; i < day.length; i++){
            if(day[i] <= preNum){
                list.set(list.size()-1, list.get(list.size()-1)+1);
            }else{
                preNum = day[i];
                list.add(1);
            }
        }
        
        int [] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        
        
        
        return answer;
    }
}