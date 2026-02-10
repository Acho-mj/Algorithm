import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 언니 위치
        k = Integer.parseInt(st.nextToken());   // 동생 위치

        // 1초후 x-1. x+1,, 순간이동 1츠 2*x
        // 수빈이가 동생을찾을  때 -> 가장 빠른 시간(초)
        if (n == k) {
            System.out.print(0);
            return;
        }
        bfs(n);
    }

    static void bfs(int start){
       Queue<Integer> q = new LinkedList<>();
       q.add(start);
       visited[start] = 1;

       while(!q.isEmpty()){
           int cur = q.poll();

           int[] dd = {cur - 1, cur + 1, cur * 2};

           for(int next : dd){
               if(next >= 0 && next <= 100000){
                   // 위치 (타켓)
                   if(next == k){
                       System.out.print(visited[cur]);
                       return;
                   }

                   // 방문하지 않은 곳
                   if(visited[next] == 0){
                       q.add(next);
                       visited[next] = visited[cur] + 1;
                   }
               }
           }
       }
    }
}