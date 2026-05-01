import java.util.*;

class Solution {
    class Point{
        String word;
        int cnt;
        
        public Point(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean [] visited = new boolean[words.length];
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(begin, 0));
        
        int answer = 0;
        
        while(!que.isEmpty()){
            Point p = que.poll();
            
            if(p.word.equals(target)){  // target과 일치한지 검사
                answer = p.cnt;
                break;
            }
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && checkWord(p.word, words[i])){
                    visited[i] = true;
                    que.add(new Point(words[i], p.cnt+1));
                }
            }
        }
        
        return answer;
    }
    
    boolean checkWord(String w1, String w2){
        int count = 0;
        for(int i = 0; i < w1.length(); i++){
            if(w1.charAt(i) != (w2.charAt(i))) count++;
        }
        
        return count == 1;  // 다른 글자가 한 개만 존재하는 지 확인
    }
}