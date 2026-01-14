import java.util.*;
import java.io.*;

public class Main {
    public static int origin = 400 * 400 * 399 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());   // 정점
        int e = Integer.parseInt(st.nextToken());   // 간선

        // a -> b인 c가 존재
        // 길이 최소인 사이클(순환) 경로
        int[][] graph = new int[v+1][v+1];
        for(int i=1; i<=v; i++){
            for(int j=1; j<=v; j++){
                graph[i][j] = origin;
            }
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[r][c] = d;
        }

        // 플로이드
        for(int k=1; k<=v; k++){
            for(int i=1; i<=v; i++){
                for(int j=1; j<=v; j++){
                    if(graph[i][k] != origin && graph[k][j] != origin){
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        // 사이클 찾기
        int cycle = origin;
        for(int i=1; i<=v; i++){
            cycle = Math.min(cycle, graph[i][i]);
        }

        if(cycle >= origin){
            System.out.print(-1);
        }else{
            System.out.print(cycle);
        }
    }
}