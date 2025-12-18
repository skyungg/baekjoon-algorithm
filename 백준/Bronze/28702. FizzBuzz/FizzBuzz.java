import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = new String[3];
		for(int i = 0; i < 3; i++) arr[i] = br.readLine();
		
		int num = 0;
		
		// 숫자 판별
		for(int i = 0; i < 3; i++) {
			if(isNumber(arr[i])){
				num = Integer.parseInt(arr[i]) + (3 - i);
                break;
			}
		}
		
		// 다음 값 판별
		if(num % 15 == 0) System.out.println("FizzBuzz");
		else if(num % 3 == 0) System.out.println("Fizz");
		else if(num % 5 == 0) System.out.println("Buzz");
		else System.out.println(num);
		
		

	}
	
	static boolean isNumber(String str) {
		for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
	}

}
