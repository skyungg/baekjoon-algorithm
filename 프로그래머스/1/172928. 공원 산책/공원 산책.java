/*
O: 길, X: 장애물, S: 시작 지점
*/

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int N = park.length;        // 행 길이
        int M = park[0].length();     // 열 길이
        
        int sx = 0;
        int sy = 0;
        char [][] arr = new char[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                arr[i][j] = park[i].charAt(j);
                if(arr[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        Map<String, int []> map = new HashMap<>();
        map.put("N", new int[]{-1, 0});
        map.put("S", new int[]{1, 0});
        map.put("W", new int[]{0, -1});
        map.put("E", new int[]{0, 1});
        
        for(int i = 0; i < routes.length; i++){
            String [] op = routes[i].split(" ");
            int step = Integer.parseInt(op[1]); // 이동 수 
            int cx = sx;
            int cy = sy;
            
            while(step > 0){
                int tx = cx + map.get(op[0])[0];
                int ty = cy + map.get(op[0])[1];
                
                if(tx < 0 || tx >= N || ty < 0 || ty >= M) break;   // 공원 벗어남
                if(arr[tx][ty] == 'X') break;       // 장애물 만남
                
                cx = tx;
                cy = ty;
                
                step--;
              
            }
            
            if(step == 0){
                sx = cx;
                sy = cy;
            }
            
            
        }
        return new int []{sx, sy};
    }
}