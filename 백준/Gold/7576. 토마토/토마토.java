import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 가로 칸 수
        m = Integer.parseInt(st.nextToken());   // 세로 칸 수

        // 토마토의 정보 (1: 익음, 0: 안익음, -1: 토마토 없음)
        // 익은 토마토 (1) 주변 - 상하좌우 - 익게 됨
       boolean isAlready = true;
        graph = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;
                if(value == 1) q.add(new int[]{i, j});
                if(value == 0) isAlready=false;
            }
        }

        // 처음부터 다 익은 상태 0 반환
        if(isAlready){
            System.out.print(0);
            return;
        }

        // bfs 시작 (큐에 미리 1인 시작점들 넣어둠)
        int total = bfs();

        // 며칠이 지나면 토마토가 다 익는지 - 최소 일수 (익지 못하면 -1 반환)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] == 0){
                    System.out.print(-1);
                    return;
                }
            }
        }

        System.out.print(total-1);
    }

    public static int bfs(){
        int lastDay = 0; // 익어가는 일수

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            lastDay = graph[x][y];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;

                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[x][y] + 1; // 이렇게 하면 방문처리도 가능하고, 일수도 누적 가능
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return lastDay;
    }
}