import java.util.*;

/*우선순위큐*/

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<int[]>> hmap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);    // 장르별 총 재생횟수
            hmap.put(genres[i], hmap.getOrDefault(genres[i], new ArrayList<>()));
            hmap.get(genres[i]).add(new int[]{i, plays[i]});    // 인덱스, 재생횟수
        }
        
        // value 기준으로 내림차순 정렬하기
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        // 같은 장르 내 정렬하기
        for(String key : hmap.keySet()){
            hmap.get(key).sort((a, b) -> {
                if(a[1] == b[1]) return a[0] - b[0];    // 같은 재생횟수 -> 고유번호순서대로
                return b[1] - a[1]; // 재생횟수가 많은 순대로       
            });         
        }

        // 찾기
        for (String key : keySet) {
            List<int[]> songList = hmap.get(key);
            for(int i = 0; i < Math.min(2, songList.size()); i++){
                list.add(songList.get(i)[0]);
            }
        }
        
        // 리스트 -> 배열로
        int [] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}