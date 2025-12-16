import java.io.*;
import java.util.*;

public class Main{
    static int [] nums;
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        // 퀵정렬 이용해보기
        quickSort(0, N-1);
        
        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for(int n : nums) sb.append(n+"\n");
        
        System.out.println(sb);
        
    }
    
    static void quickSort(int start, int end){
        if(start >= end) return;
        
        // 가운데 값을 pviot으로 
        int pivot = partition(start, end);
        quickSort(start, pivot-1);    // pivot 기준 왼쪽 영역
        quickSort(pivot, end);    // pivot 기준 오른쪽 영역
    }
    
    static int partition(int start, int end){
        int pivot = nums[(start+end)/2];
        
        while(start <= end){
            while(nums[start] < pivot) start++;    // pivot 보다 큰 값 찾기
            while(nums[end] > pivot) end--;    // pivot 보다 작은 값 찾기
            
            // 자리 교환하기
            if(start <= end){
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;            // 다음 순서로 이동
                end--;    
            }
        }
        
        return start;
    }
}