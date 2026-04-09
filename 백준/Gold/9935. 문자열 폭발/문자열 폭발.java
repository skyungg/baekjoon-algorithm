import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        char[] popArr = br.readLine().toCharArray();
        int tLen = popArr.length;

        char[] stack = new char[arr.length];
        int top = 0;

        for (char c : arr) {
            stack[top++] = c;

            if (top >= tLen && c == popArr[tLen - 1]) {    // 끝 문자가 같을때만 비교하기
                boolean flag = true;
                for (int i = 0; i < tLen; i++) {
                    if (stack[top - tLen + i] != popArr[i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    top -= tLen;
                }
            }
        }

        if (top == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(new String(stack, 0, top));
        }
    }
}