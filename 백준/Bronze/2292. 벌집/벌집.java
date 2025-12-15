import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int result = 1;
        int max = 1;

        while (N > max) {
            max += 6 * result;
            result++;
        }

        System.out.println(result);
    }
}