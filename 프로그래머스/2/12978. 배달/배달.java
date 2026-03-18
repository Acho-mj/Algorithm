import java.util.*;
class Solution {
    static int[] dist;  // 1번 마을에서 N번 마을까지의 각 최단거리
    static int INF = Integer.MAX_VALUE;
    static ArrayList<int[]>[] graph;    // road
    static boolean[] visited;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        // graph
        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int v = road[i][2];
            
            // 양방향
            graph[a].add(new int[]{b, v});
            graph[b].add(new int[]{a, v});
        }
        
        // 1번 마을에서 시작
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dij(1);
        
        for(int i=0; i<dist.length; i++){
            // K 이하일 경우 count
            if(dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }
    
    // 다익스트라 - 1번에서 각 마을까지의 최단거리 구하기
    static void dij(int start){
        // 가중치 작은 것부터
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        q.add(new int[]{start, 0});
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curNode = cur[0];
            int curCost = cur[1];
            
            if(dist[curNode] < curCost) continue;
            
            for(int[] next : graph[curNode]){
                int nextNode = next[0];
                int nextCost = next[1];
                
                if(dist[nextNode] > nextCost + curCost){
                    dist[nextNode] = nextCost + curCost;
                    q.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
        
    }
}