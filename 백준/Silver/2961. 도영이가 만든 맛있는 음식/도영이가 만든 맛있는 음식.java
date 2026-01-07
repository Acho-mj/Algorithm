import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[][] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        group = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            group[i][0] = Integer.parseInt(st.nextToken());
            group[i][1] = Integer.parseInt(st.nextToken());
        }

        // S, group[i][0]: 신맛은 *
        // B, group[i][1] : 쓴맛은 +
        dfs(0, 1, 0, false);

        System.out.print(answer);
    }

    // dfs 를 통해 차이 적은 것 구하기
    // used : 재료를 한 쌍 이상 써야함
    // s, b : 현재의 재료들의 합곱
    static void dfs(int idx, int s, int b, boolean used){
        if(idx==n){
            if(used){
                answer = Math.min(answer, Math.abs(s-b));
            }
            return;
        }
        // 재료 사용
        dfs(idx+1, s*group[idx][0], b+group[idx][1], true);

        // 재료 미사용
        dfs(idx+1, s, b, used);
    }
}