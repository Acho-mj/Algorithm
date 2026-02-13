import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<int[]> edges;
    static long[] dist;    // 최단거리 정보 저장
    static int INF = Integer.MAX_VALUE;
    static boolean hasCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 도시 개수
        m = Integer.parseInt(st.nextToken());   // 버스 노선 개수

        edges = new ArrayList<>();
        // 버스 노선의 정보 A 시작, B 도착, C 시간
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, c});
        }
        dist = new long[n+1];
        bellman();

        // 출력
        if(hasCycle){
            System.out.print(-1);
            return;
        }
        for(int i=2; i<=n; i++){
            if(dist[i] == INF){
                sb.append(-1);
            }else{
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 1번 도시에서 출발하여 나머지 도시로 가는 가장 빠른 시간
    static void bellman(){
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // 노선 m-1개 훑어보기
        for(int i=1; i<n; i++) {
            for (int[] e : edges) {
                int from = e[0];
                int to = e[1];
                int cost = e[2];

                if (dist[from] != INF && dist[to] > dist[from] + cost) {
                    dist[to] = dist[from] + cost;
                }
            }
        }

        // 음수 사이클
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            int cost = e[2];

            if (dist[from] != INF && dist[to] > dist[from] + cost) {
                hasCycle = true;
                break;
            }
        }
    }
}