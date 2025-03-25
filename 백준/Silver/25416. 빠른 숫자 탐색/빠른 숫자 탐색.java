import java.util.*;
public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] graph=new int[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static int[] fin = new int[2];
    
    public static int bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            
            // 목표 지점 도착 시 즉시 종료 (1이 있는 곳)
            if (x == fin[0] && y == fin[1]) {
                return graph[x][y];
            }
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                // range -> continue
                if(nx<0 || nx>=5 || ny<0 || ny>=5) continue;
                if(graph[nx][ny] == -1 || visited[nx][ny]) continue;
                
                
                graph[nx][ny] = graph[x][y] + 1;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                
            }   
        }
        return -1;
    }
    
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 1){
                    fin[0] = i;
                    fin[1] = j;
                }
            } 
        }
        
        int startX = sc.nextInt();
        int startY = sc.nextInt();
     
        System.out.println(bfs(startX, startY));
    }
}