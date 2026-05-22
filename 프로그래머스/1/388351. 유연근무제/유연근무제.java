class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++){
            int time = changeTime(schedules[i]);     // 출근 마지노선 
            boolean flag = true;
            
            for(int j = 0; j < 7; j++){
                int day = (startday + j-1)%7+1; // 오늘 날짜
                
                if(day == 6 || day == 7) continue;  // 토,일 제외
                
                if(timelogs[i][j] > time){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
    
    int changeTime(int time){
        int hour = time/100;
        int min = time%100;
        
        min += 10;  // 출근 인정 시간은 +10 까지
        
        if(min >= 60){
            hour++;
            min -= 60;
        }
        
        return hour*100+min;
    }
}