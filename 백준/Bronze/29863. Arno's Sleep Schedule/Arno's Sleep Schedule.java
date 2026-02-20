import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        
        int time = end - start;
        if(time < 0) time = 24+time;

        System.out.println(time);
    }
}