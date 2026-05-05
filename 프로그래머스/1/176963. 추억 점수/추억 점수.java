import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        
        int N = name.length;
        for(int i = 0; i < N; i++){
            map.put(name[i], yearning[i]);
        }
        
        int len = photo.length;
        int [] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            int sum = 0;
            for(int j = 0; j< photo[i].length; j++){
                sum += map.getOrDefault(photo[i][j], 0);
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}