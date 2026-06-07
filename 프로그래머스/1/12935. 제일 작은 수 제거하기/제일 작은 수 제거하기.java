class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        
        if(arr.length == 1) answer = new int[]{-1};
        else{
            answer = new int[arr.length-1];     // 작은 수 제거한 버전의 배열 준비
            
            int min = Integer.MAX_VALUE;
            
            for(int n : arr) min = Math.min(n, min);    // 최솟값 찾기

            int idx = 0;
            
            for(int n : arr){
                if(n != min) answer[idx++] = n;
            }
        }
        
        return answer;
    }
}