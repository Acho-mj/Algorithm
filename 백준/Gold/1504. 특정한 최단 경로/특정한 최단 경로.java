import java.util.*;
import java.io.*;

public class Main {
    static int n, e;
    static int[] dist;
    static ArrayList<int[]>[] edge;
    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 정점 개수
        e = Integer.parseInt(st.nextToken());   // 간선 개수

        // a에서 b까지 거리 c (양방향)
        edge = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            edge[i] = new ArrayList<>();
        }
        for(int i=1; i<=e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edge[a].add(new int[]{b, c});
            edge[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 각 시작점이 1, v1, v2일 때
        int[] dij1 = dij(1);
        int[] dijV1 = dij(v1);
        int[] dijV2 = dij(v2);

        // 1 -> v1 -> v2 -> n
        long result1 = (long)dij1[v1] + dijV1[v2] + dijV2[n];
        // 1 -> v2 -> v1 -> n
        long result2 = (long)dij1[v2] + dijV2[v1] + dijV1[n];
        long answer = Math.min(result1, result2);

        if(answer >= INF){
            System.out.print(-1);
        }else{
            System.out.print(answer);
        }
    }

    static int[] dij(int start){
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curIdx = cur[0];
            int curCost = cur[1];

            if (dist[curIdx] < curCost) continue;

            for(int[] next : edge[curIdx]){
                int nextIdx = next[0];
                int nextWeight = next[1];

                if(dist[nextIdx] > dist[curIdx] + nextWeight){
                    dist[nextIdx] = dist[curIdx] + nextWeight;
                    pq.add(new int[]{nextIdx, dist[nextIdx]});
                }
            }
        }
        return dist;
    }
}