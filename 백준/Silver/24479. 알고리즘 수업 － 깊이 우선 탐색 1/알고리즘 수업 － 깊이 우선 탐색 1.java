import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    static int ord = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 정점 수
        int m = Integer.parseInt(st.nextToken());   // 간선 수
        int r = Integer.parseInt(st.nextToken());   // 시작 정점

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 오름차순 방문
        for(int i=1; i<=n; i++){
            Collections.sort(graph[i]);
        }

        // DFS 호출
        visited = new boolean[n+1];
        result = new int[n+1];
        dfs(r);

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int start){
        visited[start] = true;
        result[start] = ord++;

        for(int next : graph[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}