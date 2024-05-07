import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] a = new int[1001][3];
        int [][] dp = new int[1001][3];

        int n = sc.nextInt();

        for(int i =0; i<n; i++){
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }
        dp[0][0] = a[0][0];
        dp[0][1] = a[0][1];
        dp[0][2] = a[0][2];

        for(int i =1; i<=n; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+ a[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+ a[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+ a[i][2];
        }

        int ret = Math.min(dp[n][0],dp[n][1]);
        ret = Math.min(ret,dp[n][2]);

        System.out.println(ret);

    }
}
