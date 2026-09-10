import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean [] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){        // 그 누구와도 이어지지 않았음.
                answer++;
                bfs(i, computers, visited);
            }
        }

        return answer;
    }
    
    public void bfs(int start, int [][] computers, boolean [] visited){
        Queue<Integer> que = new LinkedList<>();
        
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()){
            int num = que.poll();
            
            for(int i = 0; i < computers[num].length; i++){
                if(computers[num][i] == 1 & !visited[i]){
                    visited[i] = true;
                    que.add(i);
                }
            }
        
        }
    }
}