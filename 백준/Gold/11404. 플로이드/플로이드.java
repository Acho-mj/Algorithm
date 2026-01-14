import java.util.*;
import java.io.*;

public class Main {
    static int origin = 100000 * 100 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 도시 개수
        int m = Integer.parseInt(br.readLine());    // 버스 개수

        // 배열 초기화
        int[][] map = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j) map[i][j] = 0;
                else map[i][j] = origin;
            }
        }

        // 버스 정보 - 시작 도시 a, 도착 도시 b, 한 번 타는데 비용 c
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 최소 비용 업데이트
            map[r][c] = Math.min(map[r][c], cost);
        }

        // n개 - 도시 i에서 j로 가는 촤소 비용 (가지 못할 경우 0)
        // 중간에 거쳐서 가더라도 최소비용이 될 수 있음
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    // k가 거쳤다 가는 것
                    if(map[i][k] != origin && map[k][j] != origin)
                        map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] == origin){
                    sb.append(0 + " ");
                }else{
                    sb.append(map[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}