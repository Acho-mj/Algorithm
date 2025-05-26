import java.util.*;
class Solution {
    public boolean[][] visited = new boolean[102][102];
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public int[][] dist = new int[102][102];  // 최단거리
    public boolean[][] map = new boolean[102][102];  // 사각형의 테두리 좌표
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        // 전체 채우기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = true;
                }
            }
        }

        // 내부 지우기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2 + 1;
            int y1 = rect[1] * 2 + 1;
            int x2 = rect[2] * 2 - 1;
            int y2 = rect[3] * 2 - 1;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = false;
                }
            }
        }
        
        // 좌표를 2배 했으므로 결과값은 1/2
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }
    
    // 최단거리 이동 
    public int bfs(int characterX2, int characterY2, int itemX2, int itemY2){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterX2, characterY2});
        visited[characterX2][characterY2] = true;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
                    
            if(x==itemX2 && y==itemY2){
                return dist[x][y];
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= 102 || ny < 0 || ny >= 102) continue;
                
                if(!visited[nx][ny] && map[nx][ny]==true){
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny]=true;
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
        return 0;
    }
}