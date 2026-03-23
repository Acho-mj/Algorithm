import java.util.*;
class Solution {
    static int n;
    static int INF = 100_000_000;
    static int[][][] dist; // 최단비용
    static int[] dx = {-1, 1, 0, 0}; // 위 아래 왼 오
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        n = board.length;
        
        // dist 초기화
        dist = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    dist[i][j][k] = INF;
                }
            }
        }
        
        return dij(board);
    }
    
    static int dij(int[][] board){
        // x, y, 방향, 값
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[3] - b[3]);
        
        // 출발점 기준 - 오른쪽(3), 아래(1)
        pq.add(new int[]{0, 0, 3, 0});
        pq.add(new int[]{0, 0, 1, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curDir = cur[2];
            int curCost = cur[3];
            
            if(curX == n-1 && curY == n-1) return curCost;
            
            // 현재 비용이 dist 저장값보다 클 경우
            if(curCost > dist[curX][curY][curDir]) continue;
            
            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                // 범위 벗어날 경우
                if(nx < 0 || ny < 0 | nx > n-1 || ny > n-1) continue;
                
                // 벽이 아닐경우
                if(board[nx][ny] == 1) continue;
                
                
                int nextCost = curCost + 100;
                // 시작이 아니고, 방향이 바뀌면
                if(curDir != -1 && curDir != i){
                    nextCost += 500;
                }
                
                // 비용이 작을 경우에만 이동
                if(dist[nx][ny][i] > nextCost){
                    dist[nx][ny][i] = nextCost;   
                    pq.add(new int[]{nx, ny, i, nextCost});
                }
            }
        }
        return 0;
    }
}