import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 미로 크기
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 미로 만들기
        map = new int[n][m];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j]=line.charAt(j) - '0';
            }
        }

        // 1은 이동 가능
        // (0,0) -> (n-1,m-1) 으로 이동할 때 최소 칸 수 반환
        visited = new boolean[n][m];

        System.out.print(bfs());
    }

    static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        // (0,0)에서 시작 + 거리
        q.offer(new int[] {0, 0, 1});
        visited[0][0]=true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            // 종료조건
            if(cur[0]==n-1 && cur[1]==m-1){
                return cur[2];
            }

            for(int i=0; i<4; i++){
                int x = cur[0] + dx[i];
                int y = cur[1]  + dy[i];

                if(x>=n || y>=m || x<0 || y<0){
                    continue;
                }
                if(visited[x][y] || map[x][y] == 0) {
                    continue;
                }
                visited[x][y]=true;
                q.offer(new int[]{x, y, cur[2]+1});
            }
        }
        return -1;
    }
}