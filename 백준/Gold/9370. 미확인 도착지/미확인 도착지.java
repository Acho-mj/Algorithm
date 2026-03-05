import java.util.*;
import java.io.*;

public class Main {
    static int T, n, m, t, s, g, h, a, b, d;
    static ArrayList<int[]>[] graph;
    static int[] dest;  // 목적지 후보
    static int[] dist;  // 정점에서 인덱스까지의 거리
    static int w;   // 교차로 g, h의 거리
    static int INF = 2000001;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());   // 교차로
            m = Integer.parseInt(st.nextToken());   // 도로
            t = Integer.parseInt(st.nextToken());   // 목적지 후보의 개수

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());   // 예술가들의 출발지
            g = Integer.parseInt(st.nextToken());   // 교차로
            h = Integer.parseInt(st.nextToken());   // 교차로

            // 양방향 도로
            graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                if(a == g && b == h || a== h && b ==g){
                    w = d;
                }

                graph[a].add(new int[]{b, d});
                graph[b].add(new int[]{a, d});
            }

            // 목적지 후보
            dest = new int[t];
            for(int i=0; i<t; i++){
                dest[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(dest);

            int[] distS = dij(s);
            int[] distG = dij(g);
            int[] distH = dij(h);

            // 목적지까지의 최단거리
            for(int x : dest){
                int path1 = distS[g] + w + distH[x];    // s - g - h
                int path2 = distS[h] + w + distG[x];    // s - h - g

                // 교차로를 거치고 간 거리와 같다면
                if(distS[x] == path1 || distS[x] == path2){
                    sb.append(x).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 다익스트라
    static int[] dij(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);    // 가중치가 작은 것부터
        pq.add(new int[]{start, 0});    // start에서 모든 정점까지, 누적 비용

        int[] dist = new int[n+1];
        Arrays.fill(dist, INF); // dist 배열 초기화
        dist[start] = 0;

        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            // 이미 저장되어 있는 값이 최단거리이면 패스
            if(dist[node] < cost) continue;

            // 현재 node와 연결된 정점들
            for(int[] next : graph[node]){
                int nextNode = next[0];
                int nextCost = next[1];

                // 저장되어 있는 값이 클 경우
                if(dist[nextNode] > dist[node] + nextCost){
                    dist[nextNode] = dist[node] + nextCost;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        return dist;
    }
}