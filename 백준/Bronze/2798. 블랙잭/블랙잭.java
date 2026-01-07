import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int result = Integer.MIN_VALUE;
    static boolean[] visited;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        card = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        // 카드합 < M 이면서 M과 최대한 가까운 카드 3장의 합
        visited = new boolean[n];
        dfs(0, 0, 0);
        System.out.print(result);
    }

    // 카드 갯수
    static void dfs(int idx, int sum, int cnt){
        if(cnt == 3){
            if(sum <= m){
                result = Math.max(result, sum);
            }
            return;
        }
        for(int i=idx; i<n; i++){
            dfs(i+1, sum+card[i], cnt+1);
        }
    }
}