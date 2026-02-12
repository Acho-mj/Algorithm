import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] visited = new boolean[101];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 사다리 수
        int m = Integer.parseInt(st.nextToken());   // 뱀의 수
        int total = n+m;

        // 사다리와 뱀
        arr = new int[101];
        for(int i=1; i<=100; i++){
            arr[i] = i;
        }

        for(int i=0; i<total; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x] = y;
        }

        bfs(1, 0);
        System.out.print(sb);
    }

    static void bfs(int idx, int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{arr[idx], cnt});
        visited[1] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int index = cur[0];
            int count = cur[1];

            if(index == 100){
                sb.append(count);
                return;
            }

            // 주사위
            for(int i=1; i<=6; i++){
                int candi = index + i;
                if(candi > 100) continue;

                int next = arr[candi];
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next, count + 1});
                }
            }
        }
    }
}