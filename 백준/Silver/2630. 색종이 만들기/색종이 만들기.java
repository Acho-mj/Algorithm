import java.util.*;
import java.io.*;

public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());    // 종이 한 변 길이

        graph = new int[n][n];
        // 1이 파란색, 0이 흰색
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0, 0, n);
        System.out.print(white + "\n" + blue);
    }

    static void divide(int r, int c, int size){
        // 색이 같다면
        if(checkSameColor(r, c, size, graph)){
            if(graph[r][c] == 0) white++;
            else blue++;
            return;
        }

        int next_size = size/2;
        divide(r, c, next_size);
        divide(r, c+next_size, next_size);
        divide(r+next_size, c, next_size);
        divide(r+next_size, c+next_size, next_size);
    }

    // 정사각형 안의 컬러 확인
    static boolean checkSameColor(int r, int c, int size, int[][] graph){
        int color = graph[r][c];

        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(graph[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}