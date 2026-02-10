import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] st = new int[n+1];
        for(int i=1; i<=n; i++){
            st[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = st[1];
        if (n >= 2) {
            dp[2] = st[1] + st[2];
        }
        for(int i=3; i<=n; i++){
            // 전전까지 온 자취 + 본인, 전전전까지 온 자취 + 전 + 본인
            dp[i] = Math.max(dp[i-2]+st[i], dp[i-3]+st[i-1]+st[i]);
        }

        System.out.print(dp[n]);
    }
}