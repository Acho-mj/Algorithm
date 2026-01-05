import java.util.*;
import java.io.*;
import java.io.StringReader;

public class Main {
    public static int N, M;
    public static boolean[][] map;
    public static boolean[][] visited; // 좌표
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        visited = new boolean[N][M];

        // 음식물 쓰레기 좌표
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a-1][b-1] = true;
        }

        int answer=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(map[i][j] && !visited[i][j]){
                    answer = Math.max(answer, dfs(i, j));
                }
            }
        }
        System.out.print(answer);
    }


    // 연결된 음식물쓰레기의 사이즈 반환
    private static int dfs(int r, int c) {
        int size = 1; // 현재 위치 포함
        visited[r][c]=true;

        for(int i=0; i<4; i++){
            int dr = r + dx[i];
            int dc = c + dy[i];

            if(dr<0 || dr>=N || dc<0 || dc>=M)
                continue;

            if(map[dr][dc] && !visited[dr][dc]){
                size+=dfs(dr, dc);
            }
        }
        return size;
    }
}