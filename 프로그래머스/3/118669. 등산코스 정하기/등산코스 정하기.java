import java.util.*;
class Solution {
    static ArrayList<int[]>[] graph;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // graph 초기화
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            int a = path[0];
            int b = path[1];
            int w = path[2];
            
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});
        }
        
        // 산봉우리 여부
        Set<Integer> summitSet = new HashSet<>();
        for (int s : summits) summitSet.add(s);
        
        // 다익스트라 
        // g, s 조합으로 각각의 Intensity 구함
        // Intensity 중 최소 반환 
        // g, s를 제외한 출입구, 봉우리를 방문하지 않음
       
        return dij(n, gates, summits, summitSet);
    }
    
    static int[] dij(int n, int[] gates, int[] summits, Set<Integer> summitSet){
        // 가중치가 작은 순서대로 정렬
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        
        // 출발지를 pq에 담기
        for (int gate : gates) {
            dist[gate] = 0;
            pq.add(new int[]{gate, 0});
        }
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curCost = cur[1]; 
            
            if(dist[curNode] < curCost) continue;
            
            // 봉우리 도착
            if (summitSet.contains(curNode)) continue;
            
            for(int[] next : graph[curNode]){
                int nextNode = next[0];
                int nextCost = next[1];
                
                int intensity = Math.max(dist[curNode], nextCost);
                if (dist[nextNode] > intensity) {
                    dist[nextNode] = intensity;
                    pq.add(new int[]{nextNode, intensity});
                }
            }
        }
        
        // intensity 최소 - 봉우리의 번호가 가장 낮은 등산코스
        int minNode = -1;
        int minCost = INF;
        Arrays.sort(summits);
        for (int s : summits){
            if (dist[s] < minCost) {
                minCost = dist[s];
                minNode = s;
            }
        }
        
        return new int[]{minNode, minCost};
    }
}