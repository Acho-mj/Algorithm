import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] str = new int[n][3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                // 해당 집을 색칠하는데 드는 비용
                str[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 이웃한 집의 색은 달라야함
        // 비용의 최솟값
        // 항상 최솟값을 선택하고 이전 색깔과 다른거 선택
        // 행: 집의 번호, 열: 색깔
        int[][] dp = new int[n][3];
        for(int i=0; i<3; i++){
            dp[0][i] = str[0][i];
        }

        for(int i=1; i<n; i++){
            dp[i][0] = str[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = str[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = str[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int sum = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);

        System.out.print(sum);
    }
}