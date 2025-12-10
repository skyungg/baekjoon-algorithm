import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxNum = 0;
        int maxIdx = 0;
        for(int i = 0; i < 9; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > maxNum){
                maxNum = num;
                maxIdx = (i+1);
            }
        }
        
        System.out.println(maxNum);
        System.out.println(maxIdx);
    }
}