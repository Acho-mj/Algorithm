import java.util.*;
class Solution {
    ArrayList<int[]>[] graph;
    int[] path;
    int INF = Integer.MAX_VALUE;
    public int solution(int n, int[][] edge) {
        // 그래프 초기화
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edge){
            int a = e[0];
            int b = e[1];
            
            // 양방향 간선
            graph[a].add(new int[]{b, 1});
            graph[b].add(new int[]{a, 1});
        }
        
        path = new int[n+1];
        Arrays.fill(path, INF);
        // 다익스트라 후 path 값이 가장 큰 것들
        dij(1);
        int max = 0;
        int count = 0;
        for(int i=1; i<=n; i++){
            if(path[i] > max && path[i] != INF){
                max = path[i];
            }
        }
        
        for(int i=1; i<=n; i++){
            if(path[i] == max){
                count++;
            }
        }
        
        return count;
    }
    public void dij(int start){
        // 현재 정점
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{start, 0});
        path[start] = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDepth = cur[1];
            
            if(path[curNode] < curDepth) continue;
            
            for(int[] next : graph[curNode]){
                int nextNode = next[0];
                int nextDepth = next[1];
                if(path[nextNode] > path[curNode] + nextDepth){
                    path[nextNode] = path[curNode] + nextDepth;
                    pq.add(new int[]{nextNode, path[curNode] + nextDepth});
                }
            }
        }
        
    }
}