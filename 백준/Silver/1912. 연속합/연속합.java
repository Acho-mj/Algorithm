import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        dp[1] = arr[1];
        for(int i=2; i<=n; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            max = Math.max(dp[i], max);
        }
        System.out.print(max);
    }
}