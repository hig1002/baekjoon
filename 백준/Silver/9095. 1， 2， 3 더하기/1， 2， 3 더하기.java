import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dp[] = new int[11];
        dp[1] =1;
        dp[2] =2;
        dp[3] =4;

        for(int i =4; i<11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int t = sc.nextInt();

        while(t>0){
            int n = sc.nextInt();
            System.out.println(dp[n]);
            t--;
        }







    }
}