import java.util.*;
import java.io.*;

public class Main {
    static int INF = 20000 * 10 +1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 시작 정점
        int k = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] graph = new ArrayList[v+1];
        for(int i=1; i<=v; i++){
            graph[i]=new ArrayList<>();
        }

        // graph[i] = 시작점, end_u : 연결된 정점, w : 가중치
        for(int i=1; i<=e; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int end_u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {end_u, w});
        }

        // 최단거리 저장 (초기화)
        int[] dist = new int[v+1];
        for(int i=1; i<=v; i++){
            if(k==i){
                dist[i]=0;
            }else{
                dist[i]=INF;
            }
        }

        // 후보 pq [0]: 정점, [1]: 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int n = cur[0];
            int d = cur[1];

            // 새로운 거리가 더 크다면 pass
            if(dist[n]<d) continue;

            for(int[] link : graph[n]){
                int ln = link[0];   // 연결된 노드
                int lw = link[1];   // 연결된 노드의 가중치
                int total_dist = dist[n] + lw;

                // 저장되어있는 값보다 작을 경우 업데이트
                if(total_dist < dist[ln]){
                    dist[ln] = total_dist;
                    pq.offer(new int[]{ln, total_dist});
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=v; i++){
            if(dist[i]>=INF){
                sb.append("INF");
            }else{
                sb.append(dist[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}