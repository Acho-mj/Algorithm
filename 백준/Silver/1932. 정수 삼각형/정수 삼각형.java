import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 열 기준으로 같거나 +1 만 선택 가능, 행은 +1
        int[][] tri = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = tri[0][0];
        for(int i=1; i<n; i++){
            for(int j=0; j<=i; j++){
                if(j==0){
                    dp[i][j] = tri[i][j] + dp[i-1][j];
                }else if(j==i){
                    dp[i][j] = tri[i][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = tri[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int answer = 0;
        for (int i=0; i<n; i++) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        System.out.print(answer);
    }
}