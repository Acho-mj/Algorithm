import java.util.*;
class Solution {
    boolean[][] dist;   // [win][lose]
    int answer = 0;
    
    public int solution(int n, int[][] results) {
        floyd(n, results);
        return answer;
    }
    
    private void floyd(int n, int[][] results){
        // dist 배열 초기화 
        dist = new boolean[n+1][n+1];
        
        for(int[] node : results){
            int winner = node[0];
            int loser = node[1];
            
            dist[winner][loser] = true;
        }
        
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    // i가 k를 이기고, k가 j를 이겼을 때
                    if(dist[i][k] && dist[k][j]){
                        dist[i][j] = true;
                    }
                }
            }
        }
        
        // 나의 승패를 알고 있는 선수가 n-1 있어야 순위 확정
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                if(dist[i][j] || dist[j][i]){
                    count++;
                }
            }
            if(n-1 == count){
                answer++;
            }
        }
    }
}