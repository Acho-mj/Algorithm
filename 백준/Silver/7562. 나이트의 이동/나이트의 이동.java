import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int l, startX, startY, endX, endY;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            l = Integer.parseInt(br.readLine());     // 체스판 한 변
            visited = new int[l][l];

            // 나이트가 현재 있는 칸
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            // 나이트가 이동하려고 하는 칸
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            if (startX == endX && startY == endY) {
                sb.append(0).append("\n");
            } else {
                bfs(startX, startY);
            }
        }
        System.out.print(sb);
    }

    static void bfs(int startX, int startY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= l || ny >= l) continue;

                if(nx == endX && ny == endY){
                    sb.append(visited[x][y]).append("\n");
                    return;
                }

                // 방문하지 않았다면
                if(visited[nx][ny] == 0){
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}