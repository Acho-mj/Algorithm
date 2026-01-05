import java.util.*;
import java.io.*;
import java.io.StringReader;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫 줄
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선
        int[][] edges = new int[M][2];
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int a = edges[i][0]=Integer.parseInt(st.nextToken());
            int b = edges[i][1]=Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        // 작은 숫자부터
        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        visited = new boolean[N + 1];
        bfs(V);

    }

    private static void dfs(int V){
        visited[V]=true;
        System.out.print(V + " ");
        
        for(int next : graph[V]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int V){
       Queue<Integer> q = new LinkedList<>();
       q.add(V);
       visited[V] = true;

       while(!q.isEmpty()){
           int cur = q.poll();
           System.out.print(cur + " ");

           for(int next : graph[cur]){
               if(!visited[next]){
                   q.add(next);
                   visited[next]=true;
               }
           }
       }
    }
}