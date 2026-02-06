import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 물품의 수
        int k = Integer.parseInt(st.nextToken());   // 버틸 수 있는 무게

        int[] dp = new int[k+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());   // 무게
            int v = Integer.parseInt(st.nextToken());   // 가치

            // dp -> 무게가 j일 때 최대 가치 저장
            // 변수: 무게, dp[j]에 도달하기 위함:
            for(int j=k; j>=w; j--){
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
        }

        System.out.print(dp[k]);
    }
}