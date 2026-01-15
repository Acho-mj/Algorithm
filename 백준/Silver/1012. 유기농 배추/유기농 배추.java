import java.util.*;
import java.io.*;

public class Main {
    static int m, n;
    static int[][] graph;
    static int[] dx = {-1,1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine()); // 테스트케이스의 갯수

        // 배추의 덩어리(모여있는 곳)의 개수 반환
        ArrayList<Integer> answer = new ArrayList<>();

        // 배추의 위치 x, y
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 밭의 가로길이
            n = Integer.parseInt(st.nextToken()); // 밭의 세로길이
            graph = new int[m][n];

            int k = Integer.parseInt(st.nextToken()); // 배추의 위치 갯수
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }
            // 좌표 돌면서 bfs 호출하기
            visited = new boolean[m][n];
            int count=0;
            for(int a=0; a<m; a++){
                for(int b=0; b<n; b++){
                    if(!visited[a][b] && graph[a][b]==1){
                        bfs(a, b);
                        count++;
                    }
                }
            }
            answer.add(count);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<answer.size(); i++){
            sb.append(answer.get(i)).append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int xx = cur[0];
            int yy = cur[1];

            for(int i=0; i<4; i++){
                int a = xx + dx[i];
                int b = yy + dy[i];

                if(a<0 || b<0 || a>=m || b>=n) continue;

                if(!visited[a][b] && graph[a][b] == 1){
                    visited[a][b] = true;
                    q.offer(new int[]{a, b});
                }
            }
        }
    }
}