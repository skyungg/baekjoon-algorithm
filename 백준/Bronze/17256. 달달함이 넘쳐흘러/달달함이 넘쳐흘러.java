import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a의 x, y, z 입력
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int az = sc.nextInt();

        // c의 x, y, z 입력
        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int cz = sc.nextInt();

        // 계산 및 출력: bx = cx - az, by = cy / ay, bz = cz - ax
        System.out.println((cx - az) + " " + (cy / ay) + " " + (cz - ax));
        
        sc.close();
    }
}