import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] result;
    static boolean[] visited;

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
            int u = Integer.parseInt(st.nextToken());   // 정점 1
            int v = Integer.parseInt(st.nextToken());   // 정점 2

            // 양방향 간선
            graph[u].add(v);
            graph[v].add(u);
        }
        // 정점 내림차순
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        // 출력 - 방문 순서, 시작 정점에서 방문할 수 없을 경우 0
        visited = new boolean[n+1];
        result = new int[n+1];
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int a){
        Queue<Integer> q = new ArrayDeque<>();
        int ord=1;
        q.offer(a);
        visited[a] = true;

        while(!q.isEmpty()){
            int i = q.poll();
            result[i] = ord;

            for(int next : graph[i]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next]= true;
                }
            }
            ord++;
        }
    }
}