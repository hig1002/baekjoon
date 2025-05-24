import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int[] count = new int[10];

        for (char c : number.toCharArray()) {
            int digit = c - '0';
            if (digit == 6 || digit == 9) {
                count[6]++;  // 6과 9는 같이 처리함
            } else {
                count[digit]++;
            }
        }

        // 6과 9는 함께 취급 → 2로 나눠서 필요한 세트 수 계산
        count[6] = (count[6] + 1) / 2;

        // 전체 숫자 중 가장 많이 필요한 숫자가 세트 수
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        System.out.println(max);
    }
}