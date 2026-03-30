import java.util.*;
class Solution {
    static int n;
    static ArrayList<int[]>[] graph;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        
        // 그래프 초기화 
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] cur : fares){
            int c = cur[0];
            int d = cur[1];
            int f = cur[2];
            
            // 양방향
            graph[c].add(new int[]{d, f});
            graph[d].add(new int[]{c, f});
        }
        
        // s에서, a에서, b에서 각 dist 
        int[] startDist = dij(s);
        int[] aDist = dij(a);
        int[] bDist = dij(b);
        
        // s에서 a, s에서 b (합승하지 않응ㄴ 경우)
        long answer = (long)startDist[a] + startDist[b];
        
        // i에서 합승하는 경우
        for(int i=1; i<=n; i++){
            long cost = (long) startDist[i] + aDist[i] + bDist[i];
            answer = Math.min(answer, cost);
        }
        
        return (int)answer;
    }
    
    
    // 다익스트라
    public static int[] dij(int start) {
        // cost 비용이 작은 순서
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start, 0});
        
        // dist 배열 초기화
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            
            if(dist[curNode] < curCost) continue;
            
            for(int[] next : graph[curNode]){
                int nextNode = next[0];
                int nextCost = next[1];
                
                if(dist[nextNode] > dist[curNode] + nextCost){
                    dist[nextNode] = dist[curNode] + nextCost;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        return dist;
    }
}