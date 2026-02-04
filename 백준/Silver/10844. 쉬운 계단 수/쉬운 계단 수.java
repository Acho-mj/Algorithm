import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int MOD = 1000000000;

        long[][] dp = new long[n+1][10];
        for(int i=1; i<=9; i++){
            dp[1][i] = 1;
        }

        // [길이(n)][끝자리 수]
        for(int i=2; i<=n; i++){
            dp[i][0] = dp[i-1][1] % MOD;
            dp[i][9] = dp[i-1][8] % MOD;

            for(int j=1; j<=8; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
        }

        long cnt = 0;
        for(int i=0; i<=9; i++){
            cnt += (dp[n][i] % MOD);
        }
        System.out.print(cnt % MOD);
    }
}