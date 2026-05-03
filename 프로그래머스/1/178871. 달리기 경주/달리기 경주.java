import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        // 초기 위치 저장
        for(int i = 0; i < players.length; i++){
            map.put(players[i], i); // 이름, 순서
        }
        
        for(int i = 0; i < callings.length; i++){
            int idx = map.get(callings[i]);  // 부른 이름의 순서
            
            if(idx > 0){
                String pre = players[idx-1];
                
                players[idx-1] = callings[i];
                players[idx] = pre;
                
                // map갱신
                map.put(callings[i], idx-1);
                map.put(pre, idx);
            }
        }

        return players;
    }
}