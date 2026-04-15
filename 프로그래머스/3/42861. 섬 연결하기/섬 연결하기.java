import java.util.*;
class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        return kru(n, costs);
    }
    
    private int kru(int n, int[][] costs){
        Arrays.sort(costs, (a,b) -> a[2]-b[2]); // 비용 정렬
        
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        int totalCost = 0;  // 최소비용
        int count = 0;  // 방문한 노드
        
        for(int[] c : costs){
            int u = c[0];
            int v = c[1];
            int w = c[2];
            
            // 두 정점의 집합이 다르면 - 하나로 연결
            if(find(u) != find(v)){
                union(u, v);
                totalCost += w;
                count++;
                
                // 모든 노드를 방문
                if(count == n-1){
                    break;
                }
            }
        }
        return totalCost;
    }
    
    // 부모 노드 찾기
    private int find(int x){
        if(parent[x] == x) return x;
        
        return parent[x] = find(parent[x]);
    }
    
    // 하나의 집합으로 연결
    private void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA != rootB){
            parent[rootA] = rootB;
        }
    }
}