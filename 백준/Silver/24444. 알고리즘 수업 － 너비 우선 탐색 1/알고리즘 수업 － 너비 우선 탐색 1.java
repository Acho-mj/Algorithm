import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] order;
    static int ord=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 1부터 시작
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

        visited = new boolean[n+1];
        order = new int[n+1];
        bfs(k);

        for(int i=1; i<=n; i++){
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        order[start] = ord;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next]=true;
                    order[next] = ++ord;
                    q.add(next);
                }
            }
        }
    }
}