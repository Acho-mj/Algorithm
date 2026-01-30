import java.util.*;
import java.io.*;

public class Main {
    static int n, half;
    static int[][] graph;
    static boolean[] visited;
    static int s, l;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        half = n/2; // 각 팀 별 번호

        graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                int m = Integer.parseInt(st.nextToken());
                graph[i][j] = m;
            }
        }

        // 능력치의 차이를 최소
        // 조합 -> 여기서 최소 구하기
        visited = new boolean[n+1];
        dfs(1, 0);

        System.out.print(min);
    }

    // 조합 -> n 개 중 half 선택
    static void dfs(int idx, int cnt){
        if(cnt == half){
            culc();
            return;
        }

        for(int i=idx; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, cnt+1);

                visited[i] = false;
            }
        }
    }

    static void culc(){
        s = 0;
        l = 0;

        for(int idx1=1; idx1<=n; idx1++){
            for(int idx2=1; idx2<=n; idx2++){
                if(visited[idx1] && visited[idx2]){
                    s+=graph[idx1][idx2];
                } else if (!visited[idx1] && !visited[idx2]) {
                    l+=graph[idx1][idx2];
                }
            }
        }
        min = Math.min(min, Math.abs(s-l));
    }
}