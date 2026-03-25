import java.util.*;
import java.io.*;

public class Main {
    static int n, m, r, c, d;
    static int[][] graph;
    // 북0, 동1, 남2, 서3
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int room = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        // 방의 크기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 로봇 청소기의 좌표와 방향
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 그래프 (0은 청소 가능, 1은 벽)
        graph = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            // 현재 칸이 청소되지 않은 경우
            if(graph[r][c] == 0){
                graph[r][c] = 2;
                room++;
            }

            boolean found = false;
            // 주변 4칸 중 청소되지 않은 빈칸이 있는 경우
            for(int i=0; i<4; i++){
                // 반시계 방향으로 90도 회전
                d = (4 + (d-1)) % 4;

                // 해당 방향의 앞좌표
                int nr = r + dx[d];
                int nc = c + dy[d];

                // 청소되지 않았을 경우 해당 칸으로 이동해서 청소
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && graph[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                    found = true;
                    break;
                }
            }
            // 빈칸이 없을 경우
            if(!found){
                int backR = r - dx[d];
                int backC = c - dy[d];

                // 방향을 유지한 채 후진 (벽이라면 작동 멈춤)
                if(backR >= 0 && backR < n && backC >= 0 && backC < m && graph[backR][backC] != 1){
                    r = backR;
                    c = backC;
                }else{
                    break;
                }
            }
        }
        // 청소 가능한 방의 수
        System.out.print(room);
    }
}