import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][] arr = new int[N][2];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(arr, new Comparator<int []>(){
            @Override
            public int compare(int [] arr1, int [] arr2){
                if(arr1[1] == arr2[1]) return arr1[0] - arr2[0];
                return arr1[1] - arr2[1];
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int [] ar : arr){
            sb.append(ar[0]+" "+ar[1]+"\n");
        }
        
        System.out.println(sb);
    }
}