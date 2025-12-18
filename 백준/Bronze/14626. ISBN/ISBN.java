import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int lastNum = Integer.parseInt(String.valueOf(str.charAt(12)));		// 마지막 숫자
        int sum = 0;
        int hiddenNum = 0;
        
        for(int i = 0; i < str.length() - 1; i++) {
        	if (str.charAt(i) == '*') {
        		if(i%2 == 1) hiddenNum = 3;	// 3배 하기
        		else hiddenNum = 1;
        	}else {
        		if(i%2 == 1) sum += 3*Integer.parseInt(String.valueOf(str.charAt(i)));	// 3배 하기
        		else sum += Integer.parseInt(String.valueOf(str.charAt(i)));
        	}
        }
        
        int result = 0;
        
        for(int i = 0; i <= 9; i++) {
        	if((sum + (hiddenNum*i)+lastNum) % 10 == 0 ) {
        		result = i;
        		break;
        	}
        }
        
        System.out.println(result);

	}

}
