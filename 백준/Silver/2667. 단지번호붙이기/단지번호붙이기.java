import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx={-1, 1, 0, 0};
    static int[] dy={0, 0, -1, 1};

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // 그래프 입력
        graph = new int[n][n];
        for(int i=0; i<n; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = line.charAt(j) - '0'; // 숫자로 입력
            }
        }

        // 순화하면서 1인 곳만 가기 + 덩어리 찾기
        visited = new boolean[n][n];
        ArrayList<Integer> house = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (graph[i][j] == 1 && !visited[i][j]) {
                    house.add(bfs(i,j));
                }
            }
        }

        // 출력: 단지 갯수 + 단지 내 집 갯수 (오름차순)
        Collections.sort(house);
        StringBuilder sb = new StringBuilder();
        sb.append(house.size()).append("\n");
        for(int cnt : house){
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        int houseCnt = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int xx = cur[0];
            int yy = cur[1];

            for(int i=0; i<4; i++){
                int a = xx + dx[i];
                int b = yy + dy[i];

                // 범위를 벗어날 경우
                if(a<0 || b <0 || a>=n || b>=n) continue;

                // 아직 방문하지 않고, 1인 애들만
                if(!visited[a][b] && graph[a][b]==1){
                    houseCnt++;
                    visited[a][b]= true;
                    q.offer(new int[]{a, b});
                }
            }
        }
        return houseCnt;
    }
}