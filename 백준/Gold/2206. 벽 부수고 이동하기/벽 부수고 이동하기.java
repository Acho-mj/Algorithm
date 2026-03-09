import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][][] visited; // 방문여부, 벽 부숨:1, 안부숨:0
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 그래프 만들기
        arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            String line = br.readLine();
            for(int j=1; j<=m; j++){
                arr[i][j] = line.charAt(j-1) - '0';
            }
        }
        visited = new boolean[n+1][m+1][2];
        // 시작점 = 도착점
        if(n==1 & m==1){
            System.out.print(1);
            return;
        }

        // 벽을 부수지 않은 : 0
        System.out.print(bfs(1, 1, 1, 0));
    }

    static int bfs(int x, int y, int l, int isBroken){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, l, isBroken});
        visited[x][y][isBroken] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curL = cur[2];
            int curIsBroken = cur[3];

            // 조건에 맞을 경우
            if(curX == n && curY == m){
                return curL;
            }

            for(int i=0; i<4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 범위
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

                // 0인 경우 (갈 수 있는 길)
                if(arr[nx][ny] == 0){
                    // 방문하지 않은 경우
                    if(!visited[nx][ny][curIsBroken]){
                        visited[nx][ny][curIsBroken] = true;
                        q.add(new int[]{nx, ny, curL+1, curIsBroken});
                    }

                // 1인 경우 (벽)
                }else if(arr[nx][ny] == 1){
                    // 벽을 아직 부수지 않고 방문하지 않은 경우
                    if(curIsBroken == 0 && !visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.add(new int[]{nx, ny, curL+1, 1});
                    }
                }

            }
        }
        return -1;
    }
}