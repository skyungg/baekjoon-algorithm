import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A", 4.0);
        map.put("B+", 3.5);
        map.put("B", 3.0);
        map.put("C+", 2.5);
        map.put("C", 2.0);
        map.put("D+", 1.5);
        map.put("D", 1.0);
        map.put("F", 0.0);
        
        String str = br.readLine();
        double sum = 0;
        int cnt = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(i+1 < str.length() && str.charAt(i+1)=='+'){
                String grade = "" + str.charAt(i) + "+";
                sum += map.get(grade);
                i++;
            }else{
                String grade = "" + str.charAt(i);
                sum += map.get(grade);
            }
            cnt++;
        }

        System.out.println(sum/cnt);
        
        
    }
}