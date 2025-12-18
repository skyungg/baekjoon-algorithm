import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N > 1) {
			System.out.println(start(N));
		}else {
			System.out.println(666);	// 첫 번째는 666으로 시작
		}

	}
	
	static int start(int n) {
		int count = 1;	// 이미 666 하나 카운트
		int preNum = 0;	// 선수 자릿수
		int num = 0;	// 선수 자릿수를 제외한 나머지 뒷 자릿수
		
		while(true) {
			// 1. 선수 자릿수가 x..666x 이면서, x..666이 아닐 경우
			if(((preNum %10000) / 10) == 666 && preNum % 10 != 6){
				for(int i = 0; i < 1000; i++) {
					if(count == n) {
						return (preNum*1000 + num);
					}
					num++;
					count++;
				}
				preNum++;
			}
			// 2. 해당 수가 666으로 끝날 때
			else if(preNum % 1000 == 666) {
				num = 0;
				for(int i = 0; i < 1000; i++) {
					if(count == n) {
						return (preNum*1000+ num);
					}
					count++;
					num++;
				}
				preNum++;
			}
			// 3. 선수자릿수가 x..66 일 경우
			else if(preNum % 100 == 66) {
				num = 600;
				for(int i = 0; i < 100; i++) {
					if(count == n) {
						return (preNum*1000+ num);
					}
					count++;
					num++;
				}
				preNum++;
			}
			// 4. 선수 자릿수가 x..6일 경우
			else if(preNum % 10 == 6) {
				num = 660;
				for(int i = 0; i < 10; i++) {
					if(count == n) {
						return (preNum*1000 + num);
					}
					count++;
					num++;
				}
				preNum++;
			}
			// 5. 그외의 경우
			else {
				num = 666;
				if(count == n) return (preNum*1000 + num); 
				
				count++;
				preNum++;
			}
		}
	}

}
