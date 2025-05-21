import java.util.*;
class Solution {
    public int n, m;
    public int[][] dist;
    public boolean[][] visited;
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        n = maps.length; // row 
        m = maps[0].length; // col
        dist = new int[n][m]; // 거리
        visited = new boolean[n][m]; 
        
        // bfs 호출
        return bfs(0, 0, maps);
    }
    
    // bfs
    private int bfs(int startX, int startY, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        dist[startX][startY]=1;
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            if(x == n-1 && y == m-1){
                return dist[x][y];
            }
            // 이동
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(maps[nx][ny]==1 && !visited[nx][ny]){
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny]=true;
                        dist[nx][ny] = dist[x][y] + 1;   
                    }
                }
                
            }
        }
        
        return -1;
    }
}